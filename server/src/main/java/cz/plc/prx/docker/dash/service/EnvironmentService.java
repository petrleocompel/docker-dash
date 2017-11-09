package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnvironmentService {
    private final String COMPOSE_PROJECT = "com.docker.compose.project";
    private final String COMPOSE_SERVICE = "com.docker.compose.service";
    private final String LABEL_BLACKLIST = "LABEL_BLACKLIST";

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Environment> getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().withShowAll(true).exec();
        Map<String, List<Container>> services = new HashMap<String, List<Container>>();

        for (Container element : containerList) {
            InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(element.getId()).exec();
            List<Container> servicesContainers = new ArrayList<Container>();
            boolean isCompose = exec.getConfig().getLabels().containsKey(COMPOSE_PROJECT);
            if (isCompose && !exec.getConfig().getLabels().containsKey(LABEL_BLACKLIST)) {
                servicesContainers.add(element);
                services.put(servicesContainers.get(0).labels.get(COMPOSE_SERVICE), servicesContainers);
            }

        }

        List<Environment> environments = new ArrayList<Environment>();
        Environment env = new Environment();
        for (Map.Entry<String, List<Container>> entry : services.entrySet()) {
            List<Instance> obj = objectFactory.convert(entry.getValue(), Instance.class);
            env.addServicesItem(obj.get(0));
        }
        environments.add(env);

        return environments;
    }
}
