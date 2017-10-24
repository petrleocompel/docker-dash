package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-12T16:13:23.987Z")

@Controller
public class GetAllApiController implements GetAllApi {


    @Autowired
    private InstanceService instanceService;

    public ResponseEntity<Groups> getAll() {
        // do some magic!
        List<Instance> all = instanceService.getAll();

        Groups groups = new Groups();
        groups.setOthers(all);
        return new ResponseEntity<Groups>(groups, HttpStatus.OK);
    }

}
