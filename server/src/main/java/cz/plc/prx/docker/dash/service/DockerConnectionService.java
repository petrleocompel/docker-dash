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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Docker Connection service and holder
 */
@Service
public class DockerConnectionService {

    private static final String DEFAULT_CONNECTION = "localhost";
    private Map<String, DockerClient> connections = new HashMap<>();

    public void setConnectionToDB(List<DockerConnection> dc) throws IOException {
        File database = new File("./connections.json");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        for (DockerConnection doc :
                dc) {
            mapa.put(doc.getName(), doc);
        }
        db.commit();

        db.close();

    }

    public List<DockerConnection> getConnectionFromDB() throws IOException {
        List<DockerConnection> listOfConnections = new ArrayList<>();
        File database = new File("./connections.json");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        ConcurrentMap mapa = db.hashMap("map").createOrOpen();
        for (Object entry : mapa.values()) {
            listOfConnections.add((DockerConnection) entry);
        }
        db.close();
        return listOfConnections;

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
