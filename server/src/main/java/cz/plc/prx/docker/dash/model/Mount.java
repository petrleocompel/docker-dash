package cz.plc.prx.docker.dash.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Mount
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-28T20:43:53.160Z")

public class Mount {
    @JsonProperty("Name")
    private String name = null;

    @JsonProperty("Source")
    private String source = null;

    @JsonProperty("Destination")
    private Volume destination = null;

    @JsonProperty("Driver")
    private String driver = null;

    @JsonProperty("Mode")
    private String mode = null;

    @JsonProperty("RW")
    private Boolean RW = null;

    public Mount name(String name) {
        this.name = name;
        return this;
    }

    public static class Volume implements Serializable {
        private String path;

        public Volume(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        @Override
        public String toString() {
            return getPath();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Volume) {
                Volume other = (Volume) obj;
                return new EqualsBuilder().append(path, other.getPath()).isEquals();
            } else {
                return super.equals(obj);
            }
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(path).toHashCode();
        }

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

    public Mount source(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     **/
    @ApiModelProperty(value = "")


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Mount destination(Volume destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Get destination
     *
     * @return destination
     **/
    @ApiModelProperty(value = "")


    public Volume getDestination() {
        return destination;
    }

    public void setDestination(Volume destination) {
        this.destination = destination;
    }

    public Mount driver(String driver) {
        this.driver = driver;
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

    public Mount mode(String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Get mode
     *
     * @return mode
     **/
    @ApiModelProperty(value = "")


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Mount RW(Boolean RW) {
        this.RW = RW;
        return this;
    }

    /**
     * Get RW
     *
     * @return RW
     **/
    @ApiModelProperty(value = "")


    public Boolean getRW() {
        return RW;
    }

    public void setRW(Boolean RW) {
        this.RW = RW;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mount mount = (Mount) o;
        return Objects.equals(this.name, mount.name) &&
                Objects.equals(this.source, mount.source) &&
                Objects.equals(this.destination, mount.destination) &&
                Objects.equals(this.driver, mount.driver) &&
                Objects.equals(this.mode, mount.mode) &&
                Objects.equals(this.RW, mount.RW);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, source, destination, driver, mode, RW);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Mount {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
        sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    RW: ").append(toIndentedString(RW)).append("\n");
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

