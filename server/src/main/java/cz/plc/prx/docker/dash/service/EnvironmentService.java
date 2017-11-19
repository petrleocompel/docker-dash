package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EnvironmentService {
    private final String COMPOSE_PROJECT = "com.docker.compose.project";
    private final String LABEL_BLACKLIST = "LABEL_BLACKLIST";

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Environment> getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().withShowAll(true).exec();
        Map<String, List<Container>> services = new HashMap<String, List<Container>>();
        List<Container> servicesContainers = containerList.stream().filter(line -> line.getLabels().containsKey(COMPOSE_PROJECT))
                .collect(Collectors.toList());


        for (Container element : servicesContainers) {
            InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(element.getId()).exec();

            boolean whitelisted = (!exec.getConfig().getLabels().containsKey(LABEL_BLACKLIST) || !Boolean.valueOf(exec.getConfig().getLabels().get(LABEL_BLACKLIST)));
            if (whitelisted) {

                if (!services.containsKey(element.getLabels().get(COMPOSE_PROJECT))) {
                    List<Container> service = new ArrayList<>();
                    services.put(element.getLabels().get(COMPOSE_PROJECT), service);
                }
                for (Map.Entry<String, List<Container>> entry : services.entrySet()) {

                    if (element.getLabels().get(COMPOSE_PROJECT).compareTo(entry.getKey()) == 0) {
                        List<Container> service = entry.getValue();
                        service.add(element);
                        entry.setValue(service);
                    }

                }
            }

        }

        List<Environment> environments = new ArrayList<Environment>();
        for (Map.Entry<String, List<Container>> entry : services.entrySet()) {
            List<Container> convertContainer = entry.getValue();
            Environment env = new Environment();
            convertContainer.forEach(container -> {

                Instance obj = objectFactory.list(container, Instance.class);

                env.addServicesItem(obj);

            });
            environments.add(env);
        }


        return environments;
    }

}
