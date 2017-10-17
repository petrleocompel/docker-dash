package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.model.ListOfContainers;

import cz.plc.prx.docker.dash.service.EnvironmentService;
import cz.plc.prx.docker.dash.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

@Controller
public class GetAllApiController implements GetAllApi {


    @Autowired
    private InstanceService instanceService;

    public ResponseEntity<ListOfContainers> getAll() {
        // do some magic!
        List<Instance> all = instanceService.getAll();
        ListOfContainers listOfContainers = new ListOfContainers();
        listOfContainers.setOthers(all);
        return new ResponseEntity<ListOfContainers>(listOfContainers, HttpStatus.OK);
    }

}
