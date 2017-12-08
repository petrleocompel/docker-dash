package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import cz.plc.prx.docker.dash.model.WithDockerHost;
import cz.plc.prx.docker.dash.util.OsCheck;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotSupportedException;
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

            String ostype = OsCheck.getOperatingSystemType();

            switch (ostype) {
                case "MacOS":
                    config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                            .withDockerHost("unix:///var/run/docker.sock")
                            .build();
                    break;
                case "Linux":
                    config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                            .withDockerHost("unix:///var/run/docker.sock")
                            .build();
                    break;
                case "Windows":

                    config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                            .withDockerHost("tcp://localhost:2376")
                            .withDockerTlsVerify(true)
                            .withDockerTlsVerify("1")
                            .build();
                    break;
            }

            return DockerClientBuilder.getInstance(config).build();
        });
    }
}
