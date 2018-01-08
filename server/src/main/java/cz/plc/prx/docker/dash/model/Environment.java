package cz.plc.prx.docker.dash.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Environment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

public class Environment {
    @JsonProperty("services")
    private List<Instance> services = null;

    public Environment services(List<Instance> services) {
        this.services = (List<Instance>) services;
        return this;
    }

    public Environment addServicesItem(Instance servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<Instance>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * Get services
     *
     * @return services
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Instance> getServices() {
        return (List<Instance>) services;
    }

    public void setServices(List<Instance> services) {
        this.services = (List<Instance>) services;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Environment environment = (Environment) o;
        return Objects.equals(this.services, environment.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Environment {\n");

        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

