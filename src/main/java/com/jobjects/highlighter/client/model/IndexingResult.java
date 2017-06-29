package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * IndexingResult
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class IndexingResult {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("documentId")
  private String documentId = null;

  public IndexingResult success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * True if document indexing/extraction was successful.
   * @return success
  **/
  @ApiModelProperty(example = "true", required = true, value = "True if document indexing/extraction was successful.")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public IndexingResult documentId(String documentId) {
    this.documentId = documentId;
    return this;
  }

   /**
   * Highlighter's internal document ID.
   * @return documentId
  **/
  @ApiModelProperty(example = "c654d644b22afc66509af1a4796426c3", required = true, value = "Highlighter's internal document ID.")
  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexingResult indexingResult = (IndexingResult) o;
    return Objects.equals(this.success, indexingResult.success) &&
        Objects.equals(this.documentId, indexingResult.documentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, documentId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexingResult {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
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

