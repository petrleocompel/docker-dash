package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import org.apache.commons.lang.SystemUtils;
import org.springframework.stereotype.Service;
import org.mapdb.DBMaker.Maker;
import java.util.HashMap;
import java.util.Map;

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
    /**
     * TODO delete and make method with serverId param after thinking about it
     *
     * @return default connection to system docker
     */
    public DockerClient getDefaultConnection() {
        return connections.computeIfAbsent(DEFAULT_CONNECTION, id -> {
            DockerClientConfig config = null;

            if(SystemUtils.IS_OS_MAC_OSX){
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("unix:///var/run/docker.sock")
                        .build();
            }
            if(SystemUtils.IS_OS_LINUX){
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("unix:///var/run/docker.sock")
                        .build();
            }
            if(SystemUtils.IS_OS_WINDOWS){
                config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                        .withDockerHost("tcp://localhost:2375")
                        .withDockerTlsVerify(true)
                        .withDockerTlsVerify("1")
                        .build();
            }

            return DockerClientBuilder.getInstance(config).build();
        });
    }
}
