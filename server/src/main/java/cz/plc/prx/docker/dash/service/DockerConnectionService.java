package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import cz.plc.prx.docker.dash.model.DockerConnection;
import org.apache.commons.lang.SystemUtils;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Docker Connection service and holder
 */
@Service
public class DockerConnectionService {

    private static final String DEFAULT_CONNECTION = "localhost";
    private Map<String, DockerClient> connections = new HashMap<>();

    public void setConnectionToDB(DockerConnection dc, File configFile, File certFile) throws IOException {
        File database = new File("./connections.db");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        dc.getWithTls().setDockerCertPath(Paths.get("server/certs/").relativize(certFile.toPath()).toString());
        dc.getWithTls().setDockerConfig(Paths.get("server/certs/").relativize(configFile.toPath()).toString());
        mapa.put(dc.getName(), dc);
        db.commit();
        db.close();

    }

    public void setConnectionToDB(DockerConnection dc) throws IOException {
        File database = new File("./connections.db");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        mapa.put(UUID.randomUUID(), dc);
        db.commit();
        db.close();

    }

    public void deleteConnectionFromDB(UUID connection) throws IOException {

    }

    public Map<UUID, DockerConnection> getConnectionFromDB() throws IOException {
        Map<UUID, DockerConnection> listOfConnections = new HashMap<>();
        File database = new File("./connections.db");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        mapa.forEach((uuid, connection) -> {
            listOfConnections.put((UUID) uuid, (DockerConnection) connection);
        });
        db.close();
        return listOfConnections;

    }

    public DockerClient getConnection(UUID connection) {
        File database = new File("./connections.db");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
//        ConcurrentHashMap map = (ConcurrentHashMap) mapa;
        DockerConnection dconnection = (DockerConnection) mapa.get(connection);
        /*map.search(1, (key, value) -> {
            if (key.equals(connection)) {
                return value;
            }
            return null;
        });*/

        DockerClient dc = null;
        if (dconnection.getWithTls() != null) {
            if (dconnection.getWithTls().getDockerTLSVerify().equals("1") & !dconnection.getWithTls().getDockerCertPath().isEmpty() & !dconnection.getWithTls().getDockerConfig().isEmpty()) {
                DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost(dconnection.getAddress())
                        .withDockerTlsVerify(true)
                        .withDockerTlsVerify(dconnection.getWithTls().getDockerTLSVerify().toString())
                        .withDockerCertPath(dconnection.getWithTls().getDockerCertPath())
                        .withDockerConfig(dconnection.getWithTls().getDockerConfig())
                        .build();

                dc = DockerClientBuilder.getInstance(config).build();
            }
        } else {
            DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                    .withDockerHost(dconnection.getAddress())
                    .build();
            dc = DockerClientBuilder.getInstance(config).build();
        }
        db.close();
        return dc;
    }

    public DockerConnection getConnectionFromDB(UUID connection) throws IOException {
        DockerConnection dockerConnection = new DockerConnection();
        File database = new File("./connections.db");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        dockerConnection = (DockerConnection) mapa.getOrDefault(connection, null);

        /*if(mapa.keySet().contains(connection)){

        }
        for (Object entry : mapa.values()) {


        }*/
        db.close();
        return dockerConnection;

    }

    /**
     * TODO delete and make method with serverId param after thinking about it
     *
     * @return default connection to system docker
     */
    public DockerClient getDefaultConnection() {
        return connections.computeIfAbsent(DEFAULT_CONNECTION, id -> {
            DockerClientConfig config = null;

            if (SystemUtils.IS_OS_MAC_OSX) {
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("unix:///var/run/docker.sock")
                        .build();
            }
            if (SystemUtils.IS_OS_LINUX) {
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("unix:///var/run/docker.sock")
                        .build();
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("tcp://localhost:2376")
                        .withDockerTlsVerify(true)
                        .withDockerTlsVerify("1")
                        .build();
            }

            return DockerClientBuilder.getInstance(config).build();
        });
    }
}
