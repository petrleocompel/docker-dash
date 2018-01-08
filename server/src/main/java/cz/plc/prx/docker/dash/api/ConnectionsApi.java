/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.DockerConnection;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.InstanceExt;
import cz.plc.prx.docker.dash.model.DockerConnection;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Groups;
import cz.plc.prx.docker.dash.model.InstanceExt;
import org.springframework.core.io.Resource;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-17T20:59:13.674Z")

@Api(value = "connections", description = "the connections API")
public interface ConnectionsApi {

    @ApiOperation(value = "Delete docker connection", notes = "Delete docker connection from DB", response = Void.class, tags={ "Connections", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class),
        @ApiResponse(code = 404, message = "A connection with the specified Instance ID was not found.", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> connectionDelete(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Get connection by \"connection\" id", notes = "Return docker connection with path param connection from DB", response = DockerConnection.class, responseContainer = "List", tags={ "Connections", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DockerConnection.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<DockerConnection>> connectionGet(@ApiParam(value = "name of selected connection", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "save docker connection to DB", notes = "", response = Void.class, tags={ "Connections", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Void.class),
        @ApiResponse(code = 201, message = "successfully created", response = Void.class) })
    @RequestMapping(value = "/connections",
            consumes = {"multipart/form-data"},
            method = RequestMethod.POST)
    ResponseEntity<Void> connectionPost(@ApiParam(value = "", required = true) @RequestPart(value = "name", required = true) String name, @ApiParam(value = "", required = true) @RequestPart(value = "address", required = true) String address, @ApiParam(value = "", required = true) @RequestPart(value = "dockerTLSVerify", required = false) String dockerTLSVerify, @ApiParam(value = "") @RequestPart(value = "dockerConfig", required = false) MultipartFile dockerConfig, @ApiParam(value = "") @RequestPart(value = "file", required = false) MultipartFile upfile);



    @ApiOperation(value = "Get the services of the group named Environment", notes = "Returns array of containers", response = Environment.class, responseContainer = "List", tags={ "Environment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Environment.class, responseContainer = "List") })
    
    @RequestMapping(value = "/connections/{connection}/environment",
        method = RequestMethod.GET)
    ResponseEntity<List<Environment>> connectionsConnectionEnvironmentGet(@ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Get all connections", notes = "Return docker connections from mapDB", response = DockerConnection.class, responseContainer = "List", tags={ "Connections", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DockerConnection.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    
    @RequestMapping(value = "/connections",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Map<UUID,DockerConnection>> connectionsGet();


    @ApiOperation(value = "Restart a service selected by its ID", notes = "", response = Void.class, tags={ "Environment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/environment/{id}/restart",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> environmentRestart(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Start a service selected by its ID", notes = "", response = Void.class, tags={ "Environment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/environment/{id}/start",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> environmentStart(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Stop a service selected by its ID", notes = "", response = Void.class, tags={ "Environment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/environment/{id}/stop",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> environmentStop(@ApiParam(value = "name of selected Environment", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Get all groups", notes = "Return docker containers, compose", response = Groups.class, tags={ "Docker", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Groups.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/get-all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Groups> getAll(@ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Delete selected instance by its ID", notes = "", response = Void.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/instance/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> instanceDelete(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Get an instance selected by its ID", notes = "", response = InstanceExt.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = InstanceExt.class),
        @ApiResponse(code = 404, message = "A container with the specified Instance ID was not found.", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/instance/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InstanceExt> instanceGet(@ApiParam(value = "name of selected Instance", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Restart an instance selected by its ID", notes = "", response = Void.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/instance/{id}/restart",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> instanceRestart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Start an instance selected by its ID", notes = "", response = Void.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/instance/{id}/start",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> instanceStart(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);


    @ApiOperation(value = "Stop an instance selected by its ID", notes = "", response = Void.class, tags={ "Instance", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    
    @RequestMapping(value = "/connections/{connection}/instance/{id}/stop",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> instanceStop(@ApiParam(value = "name of selected container", required = true) @PathVariable("id") String id, @ApiParam(value = "", required = true) @PathVariable("connection") String connection);

}