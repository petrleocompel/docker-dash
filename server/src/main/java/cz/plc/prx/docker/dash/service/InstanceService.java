package cz.plc.prx.docker.dash.service;

import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerConfig;
import cz.plc.prx.docker.dash.model.ContainerConf;
import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.model.InstanceExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class InstanceService {

    @Autowired
    DockerConnectionService dcService;

    @Autowired
    ObjectFactory objectFactory;

    public List<Instance> getAll() {
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().withShowAll(true).exec();
        List<Container> runningContainers = dcService.getDefaultConnection().listContainersCmd().exec();
        for (int i = 0; i < runningContainers.size(); i++) {
            containerList.add(runningContainers.get(i));
        }

        return objectFactory.convert(containerList, Instance.class);
    }

    public List<InstanceExt> getByID(String Id) {
        List<InspectContainerResponse> instanceList = new ArrayList<InspectContainerResponse>();
        InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(Id).exec();
        instanceList.add(exec);
        List<InstanceExt> obj = objectFactory.convert(instanceList, InstanceExt.class);
        obj.get(0).setConfig(objectFactory.list(instanceList.get(0).getConfig(), ContainerConf.class));
        return obj;
    }
}
