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

public class InstanceExt extends Instance {
    @JsonProperty("Config")
    private ContainerConf containerConf;

    public ContainerConf getConfig() {
        return containerConf;
    }

    public void setConfig(ContainerConf containerConf) {
        this.containerConf = containerConf;
    }

    @JsonProperty("driver")
    private String driver = null;

    public List<String> getExecIds() {
        return execIds;
    }

    public void setExecIds(List<String> execIds) {
        this.execIds = execIds;
    }

    @JsonProperty("ExecIDs")
    private List<String> execIds;


    @JsonProperty("HostnamePath")
    private String hostnamePath = null;

    @JsonProperty("Domainname")
    private String domainName;


    @JsonProperty("Mounts")
    private List<Mount> mounts;

    public InstanceExt hostname(String hostname) {
        this.hostnamePath = hostname;
        return this;
    }

    /**
     * Get driver
     *
     * @return driver
     **/
    @ApiModelProperty(value = "")

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Get hostnamePath
     *
     * @return hostnamePath
     **/
    @ApiModelProperty(value = "")

    public String getHostnamePath() {
        return hostnamePath;
    }

    public void setHostnamePath(String hostnamePath) {
        this.hostnamePath = hostnamePath;
    }

    public InstanceExt domainname(String domainname) {
        this.domainName = domainname;
        return this;
    }

    /**
     * Get domainname
     *
     * @return domainname
     **/
    @ApiModelProperty(value = "")

    public String getDomainname() {
        return domainName;
    }

    public void setDomainname(String domainname) {
        this.domainName = domainname;
    }

    public List<Mount> getMounts() {
        return mounts;
    }

    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstanceExt instanceExt = (InstanceExt) o;
        return Objects.equals(this.hostnamePath, instanceExt.hostnamePath) &&
                Objects.equals(this.domainName, instanceExt.domainName) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostnamePath, domainName, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanceExt {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    hostnamePath: ").append(toIndentedString(hostnamePath)).append("\n");
        sb.append("    domainname: ").append(toIndentedString(domainName)).append("\n");
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

