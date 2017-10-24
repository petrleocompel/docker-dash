package cz.plc.prx.docker.dash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/**
 * Used as part of 'images/IMAGE/someimage' response.
 *
 * @author Konstantin Pelykh (kpelykh@gmail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ContainerConf {
    @JsonProperty("AttachStderr")
    private Boolean attachStderr;

    @JsonProperty("Cmd")
    private String[] cmd;

    @JsonProperty("AttachStdin")
    private Boolean attachStdin;

    public Boolean getAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(Boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public Boolean getAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(Boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public Boolean getAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(Boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    @JsonProperty("AttachStdout")
    private Boolean attachStdout;

    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContainerConf {\n");

        sb.append("    cmd: ").append(toIndentedString(Arrays.asList(cmd))).append("\n");
        sb.append("    attachStderr: ").append(toIndentedString(attachStderr)).append("\n");
        sb.append("    attachStdin: ").append(toIndentedString(attachStdin)).append("\n");
        sb.append("    attachStdout: ").append(toIndentedString(attachStdout)).append("\n");

        sb.append("}");
        return sb.toString();
    }
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

/*

    @JsonProperty("AttachStderr")
    private Boolean attachStderr;

    @JsonProperty("AttachStdin")
    private Boolean attachStdin;

    @JsonProperty("AttachStdout")
    private Boolean attachStdout;

    @JsonProperty("Cmd")
    private String[] cmd;

    @JsonProperty("Domainname")
    private String domainName;

    @JsonProperty("Entrypoint")
    private String[] entrypoint;

    @JsonProperty("Env")
    private String[] env;

    */
/*@JsonProperty("ExposedPorts")
    private ExposedPorts exposedPorts;*//*


    @JsonProperty("Hostname")
    private String hostName;

    @JsonProperty("Image")
    private String image;

    @JsonProperty("Labels")
    private Map<String, String> labels;

    @JsonProperty("MacAddress")
    private String macAddress;

    @JsonProperty("NetworkDisabled")
    private Boolean networkDisabled;

    @JsonProperty("OnBuild")
    private String[] onBuild;

    @JsonProperty("OpenStdin")
    private Boolean stdinOpen;

    @JsonProperty("PortSpecs")
    private String[] portSpecs;

    @JsonProperty("StdinOnce")
    private Boolean stdInOnce;

    @JsonProperty("Tty")
    private Boolean tty;

    @JsonProperty("User")
    private String user;

    @JsonProperty("Volumes")
    private Map<String, ?> volumes;

    @JsonProperty("WorkingDir")
    private String workingDir;

    */
/*@JsonProperty("Healthcheck")
    private HealthCheck healthCheck;*//*


    */
/*@JsonIgnore
    public ExposedPort[] getExposedPorts() {
        return exposedPorts != null ? exposedPorts.getExposedPorts() : null;
    }
*//*

    */
/**
     * @see #attachStderr
     *//*


    public Boolean getAttachStderr() {
        return attachStderr;
    }

    */
/**
     * @see #attachStderr
     *//*


    */
/**
     * @see #attachStdin
     *//*


    public Boolean getAttachStdin() {
        return attachStdin;
    }

    */
/**
     * @see #attachStdin
     *//*


    */
/**
     * @see #attachStdout
     *//*


    public Boolean getAttachStdout() {
        return attachStdout;
    }

    */
/**
     * @see #attachStdout
     *//*

    */
/**
     * @see #cmd
     *//*


    public String[] getCmd() {
        return cmd;
    }

    */
/**
     * @see #cmd
     *//*


    */
/**
     * @see #domainName
     *//*


    public String getDomainName() {
        return domainName;
    }

    */
/**
     * @see #domainName
     *//*


    */
/**
     * @see #entrypoint
     *//*


    public String[] getEntrypoint() {
        return entrypoint;
    }

    */
/**
     * @see #entrypoint
     *//*


    */
/**
     * @see #env
     *//*


    public String[] getEnv() {
        return env;
    }

    */
/**
     * @see #env
     *//*


    */
/**
     * @see #exposedPorts
     *//*


    */
/**
     * @see #hostName
     *//*


    public String getHostName() {
        return hostName;
    }

    */
/**
     * @see #hostName
     *//*


    */
/**
     * @see #image
     *//*


    public String getImage() {
        return image;
    }

    */
/**
     * @see #image
     *//*


    */
/**
     * @see #labels
     *//*


    public Map<String, String> getLabels() {
        return labels;
    }

    */
/**
     * @see #labels
     *//*


    */
/**
     * @see #macAddress
     *//*


    public String getMacAddress() {
        return macAddress;
    }

    */
/**
     * @see #macAddress
     *//*


    */
/**
     * @see #networkDisabled
     *//*


    public Boolean getNetworkDisabled() {
        return networkDisabled;
    }

    */
/**
     * @see #networkDisabled
     *//*


    */
/**
     * @see #onBuild
     *//*


    public String[] getOnBuild() {
        return onBuild;
    }

    */
/**
     * @see #onBuild
     *//*


    */
/**
     * @see #portSpecs
     *//*


    public String[] getPortSpecs() {
        return portSpecs;
    }

    */
/**
     * @see #portSpecs
     *//*


    */
/**
     * @see #stdInOnce
     *//*


    public Boolean getStdInOnce() {
        return stdInOnce;
    }

    */
/**
     * @see #stdInOnce
     *//*


    */
/**
     * @see #stdinOpen
     *//*


    public Boolean getStdinOpen() {
        return stdinOpen;
    }

    */
/**
     * @see #stdinOpen
     *//*


    */
/**
     * @see #tty
     *//*


    public Boolean getTty() {
        return tty;
    }

    */
/**
     * @see #tty
     *//*


    */
/**
     * @see #user
     *//*


    public String getUser() {
        return user;
    }

    */
/**
     * @see #user
     *//*


    */
/**
     * @see #volumes
     *//*


    public Map<String, ?> getVolumes() {
        return volumes;
    }

    */
/**
     * @see #volumes
     *//*


    */
/**
     * @see #workingDir
     *//*


    public String getWorkingDir() {
        return workingDir;
    }

    */
/**
     * @see #healthCheck
     *//*


    */
/*public HealthCheck getHealthcheck() {
        return healthCheck;
    }*//*


    */
/**
     * @see #workingDir
     *//*


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
*/
}
