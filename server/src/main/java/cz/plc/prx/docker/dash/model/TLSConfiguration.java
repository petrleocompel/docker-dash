package cz.plc.prx.docker.dash.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * TLSConfiguration
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-01T08:35:01.119Z")

public class TLSConfiguration  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("DockerTLSVerify")
  private Integer dockerTLSVerify = null;

  @JsonProperty("DockerCertPath")
  private String dockerCertPath = null;

  @JsonProperty("DockerConfig")
  private String dockerConfig = null;

  public TLSConfiguration dockerTLSVerify(Integer dockerTLSVerify) {
    this.dockerTLSVerify = dockerTLSVerify;
    return this;
  }

   /**
   * Get dockerTLSVerify
   * @return dockerTLSVerify
  **/
  @ApiModelProperty(value = "")


  public Integer getDockerTLSVerify() {
    return dockerTLSVerify;
  }

  public void setDockerTLSVerify(Integer dockerTLSVerify) {
    this.dockerTLSVerify = dockerTLSVerify;
  }

  public TLSConfiguration dockerCertPath(String dockerCertPath) {
    this.dockerCertPath = dockerCertPath;
    return this;
  }

   /**
   * Get dockerCertPath
   * @return dockerCertPath
  **/
  @ApiModelProperty(value = "")


  public String getDockerCertPath() {
    return dockerCertPath;
  }

  public void setDockerCertPath(String dockerCertPath) {
    this.dockerCertPath = dockerCertPath;
  }

  public TLSConfiguration dockerConfig(String dockerConfig) {
    this.dockerConfig = dockerConfig;
    return this;
  }

   /**
   * Get dockerConfig
   * @return dockerConfig
  **/
  @ApiModelProperty(value = "")


  public String getDockerConfig() {
    return dockerConfig;
  }

  public void setDockerConfig(String dockerConfig) {
    this.dockerConfig = dockerConfig;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TLSConfiguration tlSConfiguration = (TLSConfiguration) o;
    return Objects.equals(this.dockerTLSVerify, tlSConfiguration.dockerTLSVerify) &&
        Objects.equals(this.dockerCertPath, tlSConfiguration.dockerCertPath) &&
        Objects.equals(this.dockerConfig, tlSConfiguration.dockerConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dockerTLSVerify, dockerCertPath, dockerConfig);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TLSConfiguration {\n");
    
    sb.append("    dockerTLSVerify: ").append(toIndentedString(dockerTLSVerify)).append("\n");
    sb.append("    dockerCertPath: ").append(toIndentedString(dockerCertPath)).append("\n");
    sb.append("    dockerConfig: ").append(toIndentedString(dockerConfig)).append("\n");
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

