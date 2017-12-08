package cz.plc.prx.docker.dash.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WithDockerHost
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T07:21:29.987Z")

public class WithDockerHost   {
  @JsonProperty("Protocol")
  private String protocol = null;

  @JsonProperty("Adress")
  private String adress = null;

  @JsonProperty("Port")
  private Integer port = null;

  @JsonProperty("WithTls")
  private Boolean withTls = null;

  public WithDockerHost protocol(String protocol) {
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

  public WithDockerHost adress(String adress) {
    this.adress = adress;
    return this;
  }

   /**
   * Get adress
   * @return adress
  **/
  @ApiModelProperty(value = "")


  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public WithDockerHost port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Get port
   * @return port
  **/
  @ApiModelProperty(value = "")


  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public WithDockerHost withTls(Boolean withTls) {
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
    WithDockerHost withDockerHost = (WithDockerHost) o;
    return Objects.equals(this.protocol, withDockerHost.protocol) &&
        Objects.equals(this.adress, withDockerHost.adress) &&
        Objects.equals(this.port, withDockerHost.port) &&
        Objects.equals(this.withTls, withDockerHost.withTls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(protocol, adress, port, withTls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WithDockerHost {\n");
    
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    adress: ").append(toIndentedString(adress)).append("\n");
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

