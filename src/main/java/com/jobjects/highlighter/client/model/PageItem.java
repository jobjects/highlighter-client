package com.jobjects.highlighter.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * PageItem
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class PageItem {
  @SerializedName("page")
  private Integer page = null;

  @SerializedName("content")
  private String content = null;

  @SerializedName("length")
  private Integer length = null;

  public PageItem page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * Page number
   * @return page
  **/
  @ApiModelProperty(example = "1", required = true, value = "Page number")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PageItem content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Page text
   * @return content
  **/
  @ApiModelProperty(example = "This is page text line 1", value = "Page text")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public PageItem length(Integer length) {
    this.length = length;
    return this;
  }

   /**
   * Content length
   * @return length
  **/
  @ApiModelProperty(example = "41", value = "Content length")
  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageItem pageItem = (PageItem) o;
    return Objects.equals(this.page, pageItem.page) &&
        Objects.equals(this.content, pageItem.content) &&
        Objects.equals(this.length, pageItem.length);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, content, length);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageItem {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
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

