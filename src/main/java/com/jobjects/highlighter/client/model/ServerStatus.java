package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * ServerStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class ServerStatus {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("edition")
  private String edition = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("buildTimestamp")
  private String buildTimestamp = null;

  public ServerStatus success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public ServerStatus status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "OK", required = true, value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ServerStatus edition(String edition) {
    this.edition = edition;
    return this;
  }

   /**
   * Get edition
   * @return edition
  **/
  @ApiModelProperty(example = "Pro", required = true, value = "")
  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public ServerStatus version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(example = "3.0.1", required = true, value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ServerStatus buildTimestamp(String buildTimestamp) {
    this.buildTimestamp = buildTimestamp;
    return this;
  }

   /**
   * Get buildTimestamp
   * @return buildTimestamp
  **/
  @ApiModelProperty(example = "20170425-1130", value = "")
  public String getBuildTimestamp() {
    return buildTimestamp;
  }

  public void setBuildTimestamp(String buildTimestamp) {
    this.buildTimestamp = buildTimestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerStatus serverStatus = (ServerStatus) o;
    return Objects.equals(this.success, serverStatus.success) &&
        Objects.equals(this.status, serverStatus.status) &&
        Objects.equals(this.edition, serverStatus.edition) &&
        Objects.equals(this.version, serverStatus.version) &&
        Objects.equals(this.buildTimestamp, serverStatus.buildTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, status, edition, version, buildTimestamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerStatus {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    buildTimestamp: ").append(toIndentedString(buildTimestamp)).append("\n");
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

