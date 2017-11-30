package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.DockerConnection;
import cz.plc.prx.docker.dash.model.TLSConfiguration;
import cz.plc.prx.docker.dash.service.DockerConnectionService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-12T10:00:36.198Z")

@Controller
public class ConnectionsApiController implements ConnectionsApi {

    @Autowired
    DockerConnectionService dcservice;

    public ResponseEntity<Void> connectionDelete(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection) {

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<DockerConnection>> connectionGet(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection) {

        return new ResponseEntity<List<DockerConnection>>(HttpStatus.OK);
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
                File directory = new File("server/src/main/java/cz/plc/prx/docker/dash/certs/" + name);
                if (!directory.exists()) {
                    Files.createDirectories(directory.toPath());
                }
                MultipartFile[] files = {dockerConfig, upfile};
                List<File> fileSet = new ArrayList<>();
                for (MultipartFile file :
                        files) {
                    Path path = Paths.get("server/src/main/java/cz/plc/prx/docker/dash/certs/" + name + "/" + file.getOriginalFilename());

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


        //TODO upload file on server and save to cert path properly


        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<DockerConnection>> connectionsGet() {
        List<DockerConnection> connections = new ArrayList<>();
        try {
            connections = dcservice.getConnectionFromDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<DockerConnection>>(connections, HttpStatus.OK);
    }

}
