package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.DockerConnection;
import cz.plc.prx.docker.dash.service.DockerConnectionService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-05T15:18:26.200Z")

@Controller
public class SetDockerConnectionsApiController implements SetDockerConnectionsApi {

    @Autowired
    DockerConnectionService dcService;

    public ResponseEntity<Void> updateDockerConnections(@ApiParam(value = "docker connection model", required = true) @Valid @RequestBody DockerConnection user) {
        List<DockerConnection> connections = new ArrayList<>();
        connections.add(user);
        try {
            dcService.setConnectionToDB(connections);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
