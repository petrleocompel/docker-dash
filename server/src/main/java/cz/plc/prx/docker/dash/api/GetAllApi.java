/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cz.plc.prx.docker.dash.api;

import cz.plc.prx.docker.dash.model.ListOfContainers;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

@Api(value = "get-all", description = "the get-all API")
public interface GetAllApi {

    @ApiOperation(value = "Get projects", notes = "Return docker ps and its specs", response = ListOfContainers.class, tags={ "dockerps", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ListOfContainers.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    
    @RequestMapping(value = "/get-all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ListOfContainers> getAll();

}
