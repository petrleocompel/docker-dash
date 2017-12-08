package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.model.Container;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    @Autowired
    DockerConnectionService dcService;

    public List<Environment> getAll() {
        /*List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().exec();
        System.out.println(containerList);
        return objectFactory.convert(containerList, Instance.class);
        */
        return null;
    }
}
