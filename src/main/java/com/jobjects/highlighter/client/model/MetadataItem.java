package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * MetadataItem
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class MetadataItem {
  @SerializedName("key")
  private String key = null;

  @SerializedName("values")
  private List<String> values = new ArrayList<String>();

  public MetadataItem key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Property name
   * @return key
  **/
  @ApiModelProperty(required = true, value = "Property name")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public MetadataItem values(List<String> values) {
    this.values = values;
    return this;
  }

  public MetadataItem addValuesItem(String valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

   /**
   * Property value
   * @return values
  **/
  @ApiModelProperty(required = true, value = "Property value")
  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataItem metadataItem = (MetadataItem) o;
    return Objects.equals(this.key, metadataItem.key) &&
        Objects.equals(this.values, metadataItem.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, values);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataItem {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

