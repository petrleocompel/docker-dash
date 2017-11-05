package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EnvironmentService {

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Environment> getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().withShowAll(true).exec();
        List<Container> sifted = new ArrayList<Container>();
        for (int i = 0; i < containerList.size(); i++) {
            final int in = i;

            InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(containerList.get(i).getId()).exec();

            exec.getConfig().getLabels().computeIfPresent("com.docker.compose.project", (s, s2) -> {
                sifted.add(containerList.get(in));
                return s2;
            });
        }
        List<Instance> obj = objectFactory.convert(sifted, Instance.class);
        List<Environment> environments = new ArrayList<Environment>();
        obj.forEach(instance -> {
            environments.add(new Environment().addServicesItem(instance));
        });
        return environments;
    }
}
