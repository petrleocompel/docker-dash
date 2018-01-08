package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.model.InstanceExt;

import cz.plc.prx.docker.dash.service.DockerConnectionService;
import cz.plc.prx.docker.dash.service.InstanceService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-12T16:13:23.987Z")

@Controller
public class InstanceApiController implements InstanceApi {

    @Autowired
    DockerConnectionService docker;

    @Autowired
    private InstanceService instanceService;

    public ResponseEntity<Void> instanceDelete(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id) {
        docker.getDefaultConnection().removeContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<InstanceExt> instanceGet(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id) {
        List<InstanceExt> inst = instanceService.getByID(id);
        return new ResponseEntity<InstanceExt>(inst.get(0), HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceRestart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id) {
        docker.getDefaultConnection().restartContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceStart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id) {
        docker.getDefaultConnection().startContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceStop(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id) {
        docker.getDefaultConnection().stopContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
