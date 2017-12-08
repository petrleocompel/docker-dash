package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.DockerConnection;

import cz.plc.prx.docker.dash.service.DockerConnectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-23T12:43:47.918Z")

@Controller
public class GetDockerConnectionsApiController implements GetDockerConnectionsApi {
    @Autowired
    DockerConnectionService dcService;

    public ResponseEntity<List<DockerConnection>> getDockerConnections() {
        List<DockerConnection> connections = new ArrayList<>();
        try {
            dcService.setConnectionToDB();
            connections = dcService.getConnectionFromDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<DockerConnection>>(connections, HttpStatus.OK);
    }

}
