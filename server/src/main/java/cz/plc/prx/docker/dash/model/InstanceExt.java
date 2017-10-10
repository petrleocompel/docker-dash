package cz.plc.prx.docker.dash.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InstanceExt
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

public class InstanceExt extends Instance  {
  @JsonProperty("hostname")
  private String hostname = null;

  @JsonProperty("domainname")
  private String domainname = null;

  @JsonProperty("user")
  private String user = null;

  @JsonProperty("attachStdin")
  private Boolean attachStdin = null;

  @JsonProperty("attachStdout")
  private Boolean attachStdout = null;

  @JsonProperty("attchaStderr")
  private Boolean attchaStderr = null;

  @JsonProperty("exposedPorts")
  private Map<String, Object> exposedPorts = null;

  @JsonProperty("volumes")
  private Map<String, Object> volumes = null;

  @JsonProperty("tty")
  private Boolean tty = null;

  @JsonProperty("openStdin")
  private Boolean openStdin = null;

  @JsonProperty("stdinOnce")
  private Boolean stdinOnce = null;

  @JsonProperty("env")
  private List<String> env = null;

  @JsonProperty("cmd")
  private List<String> cmd = null;

  @JsonProperty("argsEscaped")
  private Boolean argsEscaped = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("workingDir")
  private String workingDir = null;

  @JsonProperty("entrypoint")
  private String entrypoint = null;

  @JsonProperty("onBuild")
  private String onBuild = null;

  @JsonProperty("labels")
  private Map<String, String> labels = null;

  public InstanceExt hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @ApiModelProperty(value = "")


  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public InstanceExt domainname(String domainname) {
    this.domainname = domainname;
    return this;
  }

   /**
   * Get domainname
   * @return domainname
  **/
  @ApiModelProperty(value = "")


  public String getDomainname() {
    return domainname;
  }

  public void setDomainname(String domainname) {
    this.domainname = domainname;
  }

  public InstanceExt user(String user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public InstanceExt attachStdin(Boolean attachStdin) {
    this.attachStdin = attachStdin;
    return this;
  }

   /**
   * Get attachStdin
   * @return attachStdin
  **/
  @ApiModelProperty(value = "")


  public Boolean getAttachStdin() {
    return attachStdin;
  }

  public void setAttachStdin(Boolean attachStdin) {
    this.attachStdin = attachStdin;
  }

  public InstanceExt attachStdout(Boolean attachStdout) {
    this.attachStdout = attachStdout;
    return this;
  }

   /**
   * Get attachStdout
   * @return attachStdout
  **/
  @ApiModelProperty(value = "")


  public Boolean getAttachStdout() {
    return attachStdout;
  }

  public void setAttachStdout(Boolean attachStdout) {
    this.attachStdout = attachStdout;
  }

  public InstanceExt attchaStderr(Boolean attchaStderr) {
    this.attchaStderr = attchaStderr;
    return this;
  }

   /**
   * Get attchaStderr
   * @return attchaStderr
  **/
  @ApiModelProperty(value = "")


  public Boolean getAttchaStderr() {
    return attchaStderr;
  }

  public void setAttchaStderr(Boolean attchaStderr) {
    this.attchaStderr = attchaStderr;
  }

  public InstanceExt exposedPorts(Map<String, Object> exposedPorts) {
    this.exposedPorts = exposedPorts;
    return this;
  }

  public InstanceExt putExposedPortsItem(String key, Object exposedPortsItem) {
    if (this.exposedPorts == null) {
      this.exposedPorts = new HashMap<String, Object>();
    }
    this.exposedPorts.put(key, exposedPortsItem);
    return this;
  }

   /**
   * Get exposedPorts
   * @return exposedPorts
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getExposedPorts() {
    return exposedPorts;
  }

  public void setExposedPorts(Map<String, Object> exposedPorts) {
    this.exposedPorts = exposedPorts;
  }

  public InstanceExt volumes(Map<String, Object> volumes) {
    this.volumes = volumes;
    return this;
  }

  public InstanceExt putVolumesItem(String key, Object volumesItem) {
    if (this.volumes == null) {
      this.volumes = new HashMap<String, Object>();
    }
    this.volumes.put(key, volumesItem);
    return this;
  }

   /**
   * Get volumes
   * @return volumes
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getVolumes() {
    return volumes;
  }

  public void setVolumes(Map<String, Object> volumes) {
    this.volumes = volumes;
  }

  public InstanceExt tty(Boolean tty) {
    this.tty = tty;
    return this;
  }

   /**
   * Get tty
   * @return tty
  **/
  @ApiModelProperty(value = "")


  public Boolean getTty() {
    return tty;
  }

  public void setTty(Boolean tty) {
    this.tty = tty;
  }

  public InstanceExt openStdin(Boolean openStdin) {
    this.openStdin = openStdin;
    return this;
  }

   /**
   * Get openStdin
   * @return openStdin
  **/
  @ApiModelProperty(value = "")


  public Boolean getOpenStdin() {
    return openStdin;
  }

  public void setOpenStdin(Boolean openStdin) {
    this.openStdin = openStdin;
  }

  public InstanceExt stdinOnce(Boolean stdinOnce) {
    this.stdinOnce = stdinOnce;
    return this;
  }

   /**
   * Get stdinOnce
   * @return stdinOnce
  **/
  @ApiModelProperty(value = "")


  public Boolean getStdinOnce() {
    return stdinOnce;
  }

  public void setStdinOnce(Boolean stdinOnce) {
    this.stdinOnce = stdinOnce;
  }

  public InstanceExt env(List<String> env) {
    this.env = env;
    return this;
  }

  public InstanceExt addEnvItem(String envItem) {
    if (this.env == null) {
      this.env = new ArrayList<String>();
    }
    this.env.add(envItem);
    return this;
  }

   /**
   * Get env
   * @return env
  **/
  @ApiModelProperty(value = "")


  public List<String> getEnv() {
    return env;
  }

  public void setEnv(List<String> env) {
    this.env = env;
  }

  public InstanceExt cmd(List<String> cmd) {
    this.cmd = cmd;
    return this;
  }

  public InstanceExt addCmdItem(String cmdItem) {
    if (this.cmd == null) {
      this.cmd = new ArrayList<String>();
    }
    this.cmd.add(cmdItem);
    return this;
  }

   /**
   * Get cmd
   * @return cmd
  **/
  @ApiModelProperty(value = "")


  public List<String> getCmd() {
    return cmd;
  }

  public void setCmd(List<String> cmd) {
    this.cmd = cmd;
  }

  public InstanceExt argsEscaped(Boolean argsEscaped) {
    this.argsEscaped = argsEscaped;
    return this;
  }

   /**
   * Get argsEscaped
   * @return argsEscaped
  **/
  @ApiModelProperty(value = "")


  public Boolean getArgsEscaped() {
    return argsEscaped;
  }

  public void setArgsEscaped(Boolean argsEscaped) {
    this.argsEscaped = argsEscaped;
  }

  public InstanceExt image(String image) {
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public InstanceExt workingDir(String workingDir) {
    this.workingDir = workingDir;
    return this;
  }

   /**
   * Get workingDir
   * @return workingDir
  **/
  @ApiModelProperty(value = "")


  public String getWorkingDir() {
    return workingDir;
  }

  public void setWorkingDir(String workingDir) {
    this.workingDir = workingDir;
  }

  public InstanceExt entrypoint(String entrypoint) {
    this.entrypoint = entrypoint;
    return this;
  }

   /**
   * Get entrypoint
   * @return entrypoint
  **/
  @ApiModelProperty(value = "")


  public String getEntrypoint() {
    return entrypoint;
  }

  public void setEntrypoint(String entrypoint) {
    this.entrypoint = entrypoint;
  }

  public InstanceExt onBuild(String onBuild) {
    this.onBuild = onBuild;
    return this;
  }

   /**
   * Get onBuild
   * @return onBuild
  **/
  @ApiModelProperty(value = "")


  public String getOnBuild() {
    return onBuild;
  }

  public void setOnBuild(String onBuild) {
    this.onBuild = onBuild;
  }

  public InstanceExt labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public InstanceExt putLabelsItem(String key, String labelsItem) {
    if (this.labels == null) {
      this.labels = new HashMap<String, String>();
    }
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * Get labels
   * @return labels
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceExt instanceExt = (InstanceExt) o;
    return Objects.equals(this.hostname, instanceExt.hostname) &&
        Objects.equals(this.domainname, instanceExt.domainname) &&
        Objects.equals(this.user, instanceExt.user) &&
        Objects.equals(this.attachStdin, instanceExt.attachStdin) &&
        Objects.equals(this.attachStdout, instanceExt.attachStdout) &&
        Objects.equals(this.attchaStderr, instanceExt.attchaStderr) &&
        Objects.equals(this.exposedPorts, instanceExt.exposedPorts) &&
        Objects.equals(this.volumes, instanceExt.volumes) &&
        Objects.equals(this.tty, instanceExt.tty) &&
        Objects.equals(this.openStdin, instanceExt.openStdin) &&
        Objects.equals(this.stdinOnce, instanceExt.stdinOnce) &&
        Objects.equals(this.env, instanceExt.env) &&
        Objects.equals(this.cmd, instanceExt.cmd) &&
        Objects.equals(this.argsEscaped, instanceExt.argsEscaped) &&
        Objects.equals(this.image, instanceExt.image) &&
        Objects.equals(this.workingDir, instanceExt.workingDir) &&
        Objects.equals(this.entrypoint, instanceExt.entrypoint) &&
        Objects.equals(this.onBuild, instanceExt.onBuild) &&
        Objects.equals(this.labels, instanceExt.labels) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, domainname, user, attachStdin, attachStdout, attchaStderr, exposedPorts, volumes, tty, openStdin, stdinOnce, env, cmd, argsEscaped, image, workingDir, entrypoint, onBuild, labels, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceExt {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    domainname: ").append(toIndentedString(domainname)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    attachStdin: ").append(toIndentedString(attachStdin)).append("\n");
    sb.append("    attachStdout: ").append(toIndentedString(attachStdout)).append("\n");
    sb.append("    attchaStderr: ").append(toIndentedString(attchaStderr)).append("\n");
    sb.append("    exposedPorts: ").append(toIndentedString(exposedPorts)).append("\n");
    sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
    sb.append("    tty: ").append(toIndentedString(tty)).append("\n");
    sb.append("    openStdin: ").append(toIndentedString(openStdin)).append("\n");
    sb.append("    stdinOnce: ").append(toIndentedString(stdinOnce)).append("\n");
    sb.append("    env: ").append(toIndentedString(env)).append("\n");
    sb.append("    cmd: ").append(toIndentedString(cmd)).append("\n");
    sb.append("    argsEscaped: ").append(toIndentedString(argsEscaped)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    workingDir: ").append(toIndentedString(workingDir)).append("\n");
    sb.append("    entrypoint: ").append(toIndentedString(entrypoint)).append("\n");
    sb.append("    onBuild: ").append(toIndentedString(onBuild)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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

