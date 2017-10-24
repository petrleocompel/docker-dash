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
        List<Container> containerList = dcService.getDefaultConnection().listContainersCmd().exec();
        System.out.println(containerList);
        return objectFactory.convert(containerList, Instance.class);
    }

    public List<InstanceExt>getByID(String Id) {
        List<InspectContainerResponse> instanceList= new ArrayList<InspectContainerResponse>();
        InspectContainerResponse exec = dcService.getDefaultConnection().inspectContainerCmd(Id).exec();

        instanceList.add(exec);
        System.out.println(Arrays.asList(instanceList.get(0).getConfig().getCmd()));

        List<InstanceExt>obj=objectFactory.convert(instanceList, InstanceExt.class);
        ContainerConf vv=objectFactory.list(instanceList.get(0).getConfig(), ContainerConf.class);
        obj.get(0).setConfig(vv);
        System.out.println(obj.get(0));
        return obj;
    }
}
