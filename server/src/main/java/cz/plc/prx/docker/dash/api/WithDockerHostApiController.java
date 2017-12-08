package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.DockerConnection;

import cz.plc.prx.docker.dash.service.DockerConnectionService;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T07:41:20.284Z")

@Controller
public class WithDockerHostApiController implements WithDockerHostApi {



    public ResponseEntity<DockerConnectionService> withDockerHostPost(@ApiParam(value = "The user to create."  )  @Valid @RequestBody DockerConnection user) {
        DockerConnectionService service=new DockerConnectionService();
        return new ResponseEntity<DockerConnectionService>(service,HttpStatus.OK);
    }

}