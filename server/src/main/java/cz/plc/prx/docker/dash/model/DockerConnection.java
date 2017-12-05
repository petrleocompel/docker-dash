package cz.plc.prx.docker.dash.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

/**
 * DockerConnection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T07:21:29.987Z")

public class DockerConnection  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

    @JsonProperty("Address")
    private String address = null;

    @JsonProperty("WithTls")
    private TLSConfiguration withTls = null;

    public DockerConnection name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DockerConnection address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(value = "")


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DockerConnection withTls(TLSConfiguration withTls) {
        this.withTls = withTls;
        return this;
    }

    /**
     * Get withTls
     *
     * @return withTls
     **/
    @ApiModelProperty(value = "")

    @Valid

    public TLSConfiguration getWithTls() {
        return withTls;
    }

    public void setWithTls(TLSConfiguration withTls) {
        this.withTls = withTls;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DockerConnection dockerConnection = (DockerConnection) o;
        return Objects.equals(this.name, dockerConnection.name) &&
                Objects.equals(this.address, dockerConnection.address) &&
                Objects.equals(this.withTls, dockerConnection.withTls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, withTls);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DockerConnection {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    withTls: ").append(toIndentedString(withTls)).append("\n");
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

