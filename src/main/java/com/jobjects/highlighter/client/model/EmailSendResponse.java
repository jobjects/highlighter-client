package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * EmailSendResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class EmailSendResponse {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("error")
  private String error = null;

  @SerializedName("field")
  private String field = null;

  public EmailSendResponse success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * True if emailing request was successfully scheduled for sending.
   * @return success
  **/
  @ApiModelProperty(example = "true", required = true, value = "True if emailing request was successfully scheduled for sending.")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public EmailSendResponse message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Success message
   * @return message
  **/
  @ApiModelProperty(example = "Email sent successfully", value = "Success message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public EmailSendResponse error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Error message
   * @return error
  **/
  @ApiModelProperty(example = "Recipient email address is required.", value = "Error message")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public EmailSendResponse field(String field) {
    this.field = field;
    return this;
  }

   /**
   * Input field associated with error message
   * @return field
  **/
  @ApiModelProperty(example = "emailTo", value = "Input field associated with error message")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailSendResponse emailSendResponse = (EmailSendResponse) o;
    return Objects.equals(this.success, emailSendResponse.success) &&
        Objects.equals(this.message, emailSendResponse.message) &&
        Objects.equals(this.error, emailSendResponse.error) &&
        Objects.equals(this.field, emailSendResponse.field);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message, error, field);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailSendResponse {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
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

