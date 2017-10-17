package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.model.Container;
import cz.plc.prx.docker.dash.model.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceService {

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Instance> getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().exec();
        return objectFactory.create(containerList, Instance.class);
    }
}
