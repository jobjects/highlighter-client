package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * ExtractError
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class ExtractError {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("errorCode")
  private String errorCode = null;

  @SerializedName("error")
  private String error = null;

  public ExtractError success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * True if document indexing/extraction was successful.
   * @return success
  **/
  @ApiModelProperty(example = "false", required = true, value = "True if document indexing/extraction was successful.")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public ExtractError errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

   /**
   * Error code
   * @return errorCode
  **/
  @ApiModelProperty(example = "io_error", required = true, value = "Error code")
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public ExtractError error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Error message
   * @return error
  **/
  @ApiModelProperty(example = "Not found /foo/bar.pdf", required = true, value = "Error message")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtractError extractError = (ExtractError) o;
    return Objects.equals(this.success, extractError.success) &&
        Objects.equals(this.errorCode, extractError.errorCode) &&
        Objects.equals(this.error, extractError.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, errorCode, error);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtractError {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

