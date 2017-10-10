package cz.plc.prx.docker.dash.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * ListOfContainers
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-10T07:43:14.863Z")

public class ListOfContainers   {
  @JsonProperty("environments")
  private List<Environment> environments = null;

  @JsonProperty("others")
  private List<Instance> others = null;

  public ListOfContainers environments(List<Environment> environments) {
    this.environments = environments;
    return this;
  }

  public ListOfContainers addEnvironmentsItem(Environment environmentsItem) {
    if (this.environments == null) {
      this.environments = new ArrayList<Environment>();
    }
    this.environments.add(environmentsItem);
    return this;
  }

   /**
   * Get environments
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

  public ListOfContainers others(List<Instance> others) {
    this.others = others;
    return this;
  }

  public ListOfContainers addOthersItem(Instance othersItem) {
    if (this.others == null) {
      this.others = new ArrayList<Instance>();
    }
    this.others.add(othersItem);
    return this;
  }

   /**
   * Get others
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
    ListOfContainers listOfContainers = (ListOfContainers) o;
    return Objects.equals(this.environments, listOfContainers.environments) &&
        Objects.equals(this.others, listOfContainers.others);
  }

  @Override
  public int hashCode() {
    return Objects.hash(environments, others);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOfContainers {\n");
    
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

