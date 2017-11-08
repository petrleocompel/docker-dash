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
    private final boolean LABEL_BLACKLIST = true;

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Environment>getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().withShowAll(true).exec();
        Map<String, List<Container>> services = new HashMap<String ,List<Container>>();

        List<Container> servicesContainers = new ArrayList<Container>();
        for (Container element : containerList) {
            InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(element.getId()).exec();


            List<String> composeName = new ArrayList<String>();
            exec.getConfig().getLabels().forEach((k, v) -> {

                if (k.equals(COMPOSE_PROJECT)) {
                    servicesContainers.add(element);
                    composeName.add(v);

                }

                        if (k.equals(LABEL_BLACKLIST)) {
                    // TODO black listed
                        }
            });
            if (!servicesContainers.isEmpty()&&!composeName.isEmpty()){
                services.put(composeName.get(0),servicesContainers);
                composeName.clear();
            }

            }
        List<Environment> environments = new ArrayList<Environment>();
for(Map.Entry<String , List<Container> >entry :services.entrySet()){
    Map<String, List<Instance>> convertedServices = new HashMap<String ,List<Instance>>();
        List < Instance > obj = objectFactory.convert(entry.getValue(), Instance.class);

    convertedServices.put(entry.getKey(),obj);
    Environment env= new Environment();
    env.setServices(convertedServices);
    environments.add(env);

        }


        return environments;
    }
}
