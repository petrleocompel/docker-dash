package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import cz.plc.prx.docker.dash.model.DockerConnection;
import org.apache.commons.lang.SystemUtils;
import org.mapdb.*;
import org.mapdb.serializer.SerializerArrayTuple;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Docker Connection service and holder
 */
@Service
public class DockerConnectionService {

    private static final String DEFAULT_CONNECTION = "localhost";
    private Map<String, DockerClient> connections = new HashMap<>();
    private static String protocol;
    private static String address;
    private static String socket;


    public void setConnectionToDB() throws IOException {
        File database = new File("./connections.json");
        DB db = DBMaker
                .fileDB(database)
                .transactionEnable()
                .closeOnJvmShutdown()
                .fileChannelEnable()
                .make();
        HTreeMap<String, Object[]> map =
                db.hashMap("connections")
                        .keySerializer(Serializer.STRING)
                        .valueSerializer(new SerializerArrayTuple(Serializer.STRING, Serializer.STRING, Serializer.STRING, Serializer.BOOLEAN))
                        .createOrOpen();

        map.put("unix", new Object[]{"unix", "/var/run", "docker.sock", false});
        map.put("windows", new Object[]{"tcp", "localhost", "2375", true});
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
        HTreeMap<String, Object[]> map =
                db.hashMap("connections")
                        .keySerializer(Serializer.STRING)
                        .valueSerializer(new SerializerArrayTuple(Serializer.STRING, Serializer.STRING, Serializer.STRING, Serializer.BOOLEAN))
                        .createOrOpen();

        Collection<Object[]> object = map.getValues();

        for (Object[] index :
                object) {
            DockerConnection wdh = new DockerConnection();
            wdh.setProtocol((String) index[0]);
            wdh.setAddress((String) index[1]);
            wdh.setPort((String) index[2]);
            wdh.setWithTls((Boolean) index[3]);
            listOfConnections.add(wdh);
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
