package cz.plc.prx.docker.dash.service;

public class ContainersService {
    public String getByID(String Id){
        DockerConnectionService dc=new DockerConnectionService();
        String containers = dc.getDefaultConnection().inspectContainerCmd(Id).exec().toString();

        return containers;
    }
}
