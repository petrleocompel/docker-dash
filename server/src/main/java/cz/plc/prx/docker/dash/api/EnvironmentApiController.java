package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Environment;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

@Controller
public class EnvironmentApiController implements EnvironmentApi {



    public ResponseEntity<Void> environmentDelete(@ApiParam(value = "name of selected container",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Environment>> environmentGet() {
        // do some magic!
        return new ResponseEntity<List<Environment>>(HttpStatus.OK);
    }

    public ResponseEntity<Environment> environmentGet(@ApiParam(value = "name of selected container",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Environment>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentRestart(@ApiParam(value = "name of selected container",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStart(@ApiParam(value = "name of selected container",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStop(@ApiParam(value = "name of selected container",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
