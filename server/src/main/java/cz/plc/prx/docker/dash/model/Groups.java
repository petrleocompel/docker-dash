package cz.plc.prx.docker.dash.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import cz.plc.prx.docker.dash.model.Environment;
import cz.plc.prx.docker.dash.model.Instance;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Groups
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-12T16:13:23.987Z")

public class Groups {
    @JsonProperty("environments")
    private List<Environment> environments = null;

    @JsonProperty("others")
    private List<Instance> others = null;

    public Groups environments(List<Environment> environments) {
        this.environments = environments;
        return this;
    }

    public Groups addEnvironmentsItem(Environment environmentsItem) {
        if (this.environments == null) {
            this.environments = new ArrayList<Environment>();
        }
        this.environments.add(environmentsItem);
        return this;
    }

    /**
     * Get environments
     *
     * @return environments
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<Environment> environments) {
        this.environments = environments;
    }

    public Groups others(List<Instance> others) {
        this.others = others;
        return this;
    }

    public Groups addOthersItem(Instance othersItem) {
        if (this.others == null) {
            this.others = new ArrayList<Instance>();
        }
        this.others.add(othersItem);
        return this;
    }

    /**
     * Get others
     *
     * @return others
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Instance> getOthers() {
        return others;
    }

    public void setOthers(List<Instance> others) {
        this.others = others;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Groups groups = (Groups) o;
        return Objects.equals(this.environments, groups.environments) &&
                Objects.equals(this.others, groups.others);
    }

    @Override
    public int hashCode() {
        return Objects.hash(environments, others);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Groups {\n");

        sb.append("    environments: ").append(toIndentedString(environments)).append("\n");
        sb.append("    others: ").append(toIndentedString(others)).append("\n");
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

