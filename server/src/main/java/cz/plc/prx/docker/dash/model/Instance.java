package cz.plc.prx.docker.dash.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Instance
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T12:58:13.914Z")

public class Instance {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("created")
    private String created = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("args")
    private List<String> args = null;

    @JsonProperty("image")
    private String image = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("imageId")
    private String imageId = null;

    @JsonProperty("status")
    private String status = null;

    public Instance id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instance created(String created) {
        this.created = created;
        return this;
    }

    /**
     * Get created
     *
     * @return created
     **/
    @ApiModelProperty(value = "")


    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Instance path(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    @ApiModelProperty(value = "")


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Instance args(List<String> args) {
        this.args = args;
        return this;
    }

    public Instance addArgsItem(String argsItem) {
        if (this.args == null) {
            this.args = new ArrayList<String>();
        }
        this.args.add(argsItem);
        return this;
    }

    /**
     * Get args
     *
     * @return args
     **/
    @ApiModelProperty(value = "")


    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public Instance image(String image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    @ApiModelProperty(value = "")


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Instance name(String name) {
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

    public Instance imageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    /**
     * Get imageId
     *
     * @return imageId
     **/
    @ApiModelProperty(value = "")


    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Instance status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @ApiModelProperty(value = "")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Instance instance = (Instance) o;
        return Objects.equals(this.id, instance.id) &&
                Objects.equals(this.created, instance.created) &&
                Objects.equals(this.path, instance.path) &&
                Objects.equals(this.args, instance.args) &&
                Objects.equals(this.image, instance.image) &&
                Objects.equals(this.name, instance.name) &&
                Objects.equals(this.imageId, instance.imageId) &&
                Objects.equals(this.status, instance.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, path, args, image, name, imageId, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Instance {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    args: ").append(toIndentedString(args)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

