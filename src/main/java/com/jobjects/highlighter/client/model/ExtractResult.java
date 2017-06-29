package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * ExtractResult
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class ExtractResult {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("metadata")
  private List<MetadataItem> metadata = new ArrayList<MetadataItem>();

  @SerializedName("pages")
  private List<PageItem> pages = new ArrayList<PageItem>();

  public ExtractResult success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * True if document indexing/extraction was successfull.
   * @return success
  **/
  @ApiModelProperty(example = "true", required = true, value = "True if document indexing/extraction was successfull.")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public ExtractResult metadata(List<MetadataItem> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ExtractResult addMetadataItem(MetadataItem metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

   /**
   * Document metadata with Highlighter's internal document ID.
   * @return metadata
  **/
  @ApiModelProperty(example = "[{&quot;key&quot;:&quot;meta:title&quot;,&quot;values&quot;:[&quot;Document title&quot;]},{&quot;key&quot;:&quot;xmp:MetadataDate&quot;,&quot;values&quot;:[&quot;2014-11-13T16:12:39+01:00&quot;]},{&quot;key&quot;:&quot;pdfx:SourceModified&quot;,&quot;values&quot;:[&quot;D:20141113151110&quot;]}]", value = "Document metadata with Highlighter's internal document ID.")
  public List<MetadataItem> getMetadata() {
    return metadata;
  }

  public void setMetadata(List<MetadataItem> metadata) {
    this.metadata = metadata;
  }

  public ExtractResult pages(List<PageItem> pages) {
    this.pages = pages;
    return this;
  }

  public ExtractResult addPagesItem(PageItem pagesItem) {
    this.pages.add(pagesItem);
    return this;
  }

   /**
   * Document pages
   * @return pages
  **/
  @ApiModelProperty(value = "Document pages")
  public List<PageItem> getPages() {
    return pages;
  }

  public void setPages(List<PageItem> pages) {
    this.pages = pages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtractResult extractResult = (ExtractResult) o;
    return Objects.equals(this.success, extractResult.success) &&
        Objects.equals(this.metadata, extractResult.metadata) &&
        Objects.equals(this.pages, extractResult.pages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, metadata, pages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtractResult {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
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

