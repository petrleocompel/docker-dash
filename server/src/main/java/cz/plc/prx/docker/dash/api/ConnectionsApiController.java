package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.*;
import cz.plc.prx.docker.dash.service.DockerConnectionService;
import cz.plc.prx.docker.dash.service.EnvironmentService;
import cz.plc.prx.docker.dash.service.InstanceService;
import cz.plc.prx.docker.dash.model.DockerConnection;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.InstanceExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.validation.constraints.*;
import javax.validation.Valid;

import static java.nio.file.StandardOpenOption.CREATE;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-17T20:59:13.674Z")

@Controller
public class ConnectionsApiController implements ConnectionsApi {

    @Autowired
    DockerConnectionService dcservice;

    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private InstanceService instanceService;

    public ResponseEntity<Void> connectionDelete(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<DockerConnection>> connectionGet(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection) {
        List<DockerConnection> dockerConnection=new ArrayList<>();
        try {
          dockerConnection.add(dcservice.getConnectionFromDB(UUID.fromString(connection)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<DockerConnection>>(dockerConnection,HttpStatus.OK);
    }

    public ResponseEntity<Void> connectionPost(@ApiParam(value = "", required = true) @RequestPart(value = "name", required = true) String name,
                                               @ApiParam(value = "", required = true) @RequestPart(value = "address", required = true) String address,
                                               @ApiParam(value = "", required = true) @RequestPart(value = "dockerTLSVerify", required = false) String dockerTLSVerify,
                                               @ApiParam(value = "") @RequestParam(value = "dockerConfig", required = false) MultipartFile dockerConfig,
                                               @ApiParam(value = "") @RequestParam(value = "file", required = false) MultipartFile upfile) {
        DockerConnection dc;
        dc = new DockerConnection();
        dc.setAddress(address);
        dc.setName(name);
        if (dockerTLSVerify.equals("1") && !dockerTLSVerify.isEmpty()) {
            TLSConfiguration tls = new TLSConfiguration();
            tls.setDockerTLSVerify(Integer.parseInt(dockerTLSVerify));
            dc.setWithTls(tls);
            try {
                File directory = new File("server/certs/" + name);
                if (!directory.exists()) {
                    Files.createDirectories(directory.toPath());
                }
                MultipartFile[] files = {dockerConfig, upfile};
                List<File> fileSet = new ArrayList<>();
                for (MultipartFile file :
                        files) {
                    Path path = Paths.get("server/certs/" + name + "/" + file.getOriginalFilename());

                    if (!Files.exists(path)) {
                        OutputStream os = new BufferedOutputStream(Files.newOutputStream(path, CREATE));
                        os.write(file.getBytes());
                        os.close();
                        File f = path.toFile();
                        fileSet.add(f);
                    }
                }
                dcservice.setConnectionToDB(dc, fileSet.get(0), fileSet.get(1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                dcservice.setConnectionToDB(dc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Map<UUID,DockerConnection>> connectionsGet() {
        Map<UUID,DockerConnection> connections = new HashMap<>();
        try {
            connections = dcservice.getConnectionFromDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Map<UUID,DockerConnection>>(connections, HttpStatus.OK);
    }

    public ResponseEntity<List<Environment>> connectionsConnectionEnvironmentGet(@ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        List<Environment> all = environmentService.getAll(UUID.fromString(connection));
        return new ResponseEntity<List<Environment>>(all, HttpStatus.OK);
    }


    public ResponseEntity<Void> environmentRestart(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id,
                                                   @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        environmentService.environmentServiceAction(id, EnvironmentService.ServiceAction.Restart,UUID.fromString(connection));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStart(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id,
                                                 @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        environmentService.environmentServiceAction(id, EnvironmentService.ServiceAction.Start,UUID.fromString(connection));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> environmentStop(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id,
                                                @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        environmentService.environmentServiceAction(id, EnvironmentService.ServiceAction.Stop,UUID.fromString(connection));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Groups> getAll(@ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        List<Instance> instance = instanceService.getAll();
        List<Environment> environment = environmentService.getAll(UUID.fromString(connection));
        Groups groups = new Groups();
        groups.setOthers(instance);

        groups.setEnvironments(environment);
        return new ResponseEntity<Groups>(groups, HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceDelete(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id,
                                               @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        dcservice.getConnection(UUID.fromString(connection)).removeContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<InstanceExt> instanceGet(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id,
                                                   @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        List<InstanceExt> inst = instanceService.getByID(id);
        return new ResponseEntity<InstanceExt>(inst.get(0), HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceRestart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id,
                                                @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        dcservice.getConnection(UUID.fromString(connection)).restartContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceStart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id,
                                              @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        dcservice.getConnection(UUID.fromString(connection)).startContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> instanceStop(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id,
                                             @ApiParam(value = "", required = true) @PathVariable("connection") String connection) {
        dcservice.getConnection(UUID.fromString(connection)).stopContainerCmd(id).exec();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
