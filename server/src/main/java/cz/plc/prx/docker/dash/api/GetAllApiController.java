package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.ListOfContainers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

@Controller
public class GetAllApiController implements GetAllApi {



    public ResponseEntity<ListOfContainers> getAll() {
        // do some magic!
        return new ResponseEntity<ListOfContainers>(HttpStatus.OK);
    }

}
