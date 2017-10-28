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
import java.util.Objects;

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

    @JsonProperty("AttachStdin")
    private Boolean attachStdin;

    @JsonProperty("AttachStdout")
    private Boolean attachStdout;

    @JsonProperty("Cmd")
    private String[] cmd;

    @JsonProperty("Entrypoint")
    private String[] entrypoint;

    @JsonProperty("Env")
    private String[] env;

    @JsonProperty("Hostname")
    private String hostName;

    @JsonProperty("Labels")
    private Map<String, String> labels;

    @JsonProperty("WorkingDir")
    private String workingDir;


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


    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContainerConf containerConf = (ContainerConf) o;
        return Objects.equals(this.attachStderr, containerConf.attachStderr) &&
                Objects.equals(this.attachStdin, containerConf.attachStdin) &&
                Objects.equals(this.attachStdout, containerConf.attachStdout) &&
                Objects.equals(this.cmd, containerConf.cmd) &&
                Objects.equals(this.entrypoint, containerConf.entrypoint) &&
                Objects.equals(this.env, containerConf.env) &&
                Objects.equals(this.hostName, containerConf.hostName) &&
                Objects.equals(this.labels, containerConf.labels) &&
                Objects.equals(this.workingDir, containerConf.workingDir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachStderr, attachStdin, attachStdout, cmd, entrypoint, env, hostName, labels, workingDir);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContainerConf {\n");

        sb.append("    attachStderr: ").append(toIndentedString(attachStderr)).append("\n");
        sb.append("    attachStdin: ").append(toIndentedString(attachStdin)).append("\n");
        sb.append("    attachStdout: ").append(toIndentedString(attachStdout)).append("\n");
        sb.append("    cmd: ").append(toIndentedString(cmd)).append("\n");
        sb.append("    entrypoint: ").append(toIndentedString(entrypoint)).append("\n");
        sb.append("    env: ").append(toIndentedString(env)).append("\n");
        sb.append("    hostname: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    workingDir: ").append(toIndentedString(workingDir)).append("\n");
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

    public String[] getEnv() {
        return env;
    }

    public void setEnv(String[] env) {
        this.env = env;
    }

    public String[] getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(String[] entrypoint) {
        this.entrypoint = entrypoint;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * @see #labels
     */
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;

    }
}
