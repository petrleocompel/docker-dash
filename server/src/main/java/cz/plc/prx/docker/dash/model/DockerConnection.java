package cz.plc.prx.docker.dash.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * DockerConnection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T07:21:29.987Z")

public class DockerConnection {
  @JsonProperty("Protocol")
  private String protocol = null;

  @JsonProperty("Address")
  private String address = null;

  @JsonProperty("Port")
  private String port = null;

  @JsonProperty("WithTls")
  private Boolean withTls = null;

  public DockerConnection protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @ApiModelProperty(value = "")


  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public DockerConnection address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public DockerConnection port(String port) {
    this.port = port;
    return this;
  }

   /**
   * Get port
   * @return port
  **/
  @ApiModelProperty(value = "")


  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public DockerConnection withTls(Boolean withTls) {
    this.withTls = withTls;
    return this;
  }

   /**
   * Get withTls
   * @return withTls
  **/
  @ApiModelProperty(value = "")


  public Boolean getWithTls() {
    return withTls;
  }

  public void setWithTls(Boolean withTls) {
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
    return Objects.equals(this.protocol, dockerConnection.protocol) &&
        Objects.equals(this.address, dockerConnection.address) &&
        Objects.equals(this.port, dockerConnection.port) &&
        Objects.equals(this.withTls, dockerConnection.withTls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(protocol, address, port, withTls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DockerConnection {\n");
    
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

