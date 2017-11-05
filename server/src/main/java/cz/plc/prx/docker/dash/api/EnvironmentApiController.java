package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Environment;

import cz.plc.prx.docker.dash.service.EnvironmentService;
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

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-12T16:13:23.987Z")

@Controller
public class EnvironmentApiController implements EnvironmentApi {

    @Autowired
    private EnvironmentService environmentService;


    public ResponseEntity<Void> environmentDelete(@ApiParam(value = "name of selected Environment",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Environment>> environmentGet() {
        // do some magic!
        List<Environment> all = environmentService.getAll();


        return new ResponseEntity<List<Environment>>(all,HttpStatus.OK);
    }

    public ResponseEntity<Environment> environmentGet(@ApiParam(value = "name of selected Environment",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Environment>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentRestart(@ApiParam(value = "name of selected Environment",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStart(@ApiParam(value = "name of selected Environment",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStop(@ApiParam(value = "name of selected Environment",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
