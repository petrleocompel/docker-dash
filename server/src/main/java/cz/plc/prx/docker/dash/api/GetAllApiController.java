package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.Instance;
import cz.plc.prx.docker.dash.model.ListOfContainers;
import io.swagger.annotations.*;
import cz.plc.prx.docker.dash.service.EnvironmentService;
import cz.plc.prx.docker.dash.service.InstanceService;
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
