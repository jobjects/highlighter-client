package com.jobjects.highlighter.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * HighlightingResult
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-07T10:40:43.878Z")
public class HighlightingResult {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("cacheKey")
  private String cacheKey = null;

  @SerializedName("documentUrl")
  private String documentUrl = null;

  @SerializedName("highlightedPages")
  private Integer highlightedPages = null;

  @SerializedName("pagesWithMatches")
  private List<Integer> pagesWithMatches = new ArrayList<Integer>();

  @SerializedName("highlightedTerms")
  private Integer highlightedTerms = null;

  @SerializedName("navigationStrategy")
  private String navigationStrategy = null;

  public HighlightingResult success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Success status
   * @return success
  **/
  @ApiModelProperty(example = "true", value = "Success status")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public HighlightingResult cacheKey(String cacheKey) {
    this.cacheKey = cacheKey;
    return this;
  }

   /**
   * Result cache key
   * @return cacheKey
  **/
  @ApiModelProperty(example = "718948ce91fbdfc546e1b9f38d50e8d6", value = "Result cache key")
  public String getCacheKey() {
    return cacheKey;
  }

  public void setCacheKey(String cacheKey) {
    this.cacheKey = cacheKey;
  }

  public HighlightingResult documentUrl(String documentUrl) {
    this.documentUrl = documentUrl;
    return this;
  }

   /**
   * URL to highlighted document. Depending on settings and request parameters it links to PDF Highlighted Viewer or PDF with burned in highlights.
   * @return documentUrl
  **/
  @ApiModelProperty(example = "/viewer/?file&#x3D;http%3A%2F%2Flocalhost%3A28081%2Fexamples%2Ftest.pdf&amp;highlightsFile&#x3D;...", value = "URL to highlighted document. Depending on settings and request parameters it links to PDF Highlighted Viewer or PDF with burned in highlights.")
  public String getDocumentUrl() {
    return documentUrl;
  }

  public void setDocumentUrl(String documentUrl) {
    this.documentUrl = documentUrl;
  }

  public HighlightingResult highlightedPages(Integer highlightedPages) {
    this.highlightedPages = highlightedPages;
    return this;
  }

   /**
   * Number of highlighted pages.
   * @return highlightedPages
  **/
  @ApiModelProperty(example = "2", value = "Number of highlighted pages.")
  public Integer getHighlightedPages() {
    return highlightedPages;
  }

  public void setHighlightedPages(Integer highlightedPages) {
    this.highlightedPages = highlightedPages;
  }

  public HighlightingResult pagesWithMatches(List<Integer> pagesWithMatches) {
    this.pagesWithMatches = pagesWithMatches;
    return this;
  }

  public HighlightingResult addPagesWithMatchesItem(Integer pagesWithMatchesItem) {
    this.pagesWithMatches.add(pagesWithMatchesItem);
    return this;
  }

   /**
   * An array with page numbers where matches were found.
   * @return pagesWithMatches
  **/
  @ApiModelProperty(example = "[1,6]", value = "An array with page numbers where matches were found.")
  public List<Integer> getPagesWithMatches() {
    return pagesWithMatches;
  }

  public void setPagesWithMatches(List<Integer> pagesWithMatches) {
    this.pagesWithMatches = pagesWithMatches;
  }

  public HighlightingResult highlightedTerms(Integer highlightedTerms) {
    this.highlightedTerms = highlightedTerms;
    return this;
  }

   /**
   * Number of highlighted terms.
   * @return highlightedTerms
  **/
  @ApiModelProperty(example = "3", value = "Number of highlighted terms.")
  public Integer getHighlightedTerms() {
    return highlightedTerms;
  }

  public void setHighlightedTerms(Integer highlightedTerms) {
    this.highlightedTerms = highlightedTerms;
  }

  public HighlightingResult navigationStrategy(String navigationStrategy) {
    this.navigationStrategy = navigationStrategy;
    return this;
  }

   /**
   * Navigation strategy to use in PDF Highlighting Viewer (\"hit-to-hit\" or \"page-to-page\")
   * @return navigationStrategy
  **/
  @ApiModelProperty(example = "hit-to-hit", value = "Navigation strategy to use in PDF Highlighting Viewer (\"hit-to-hit\" or \"page-to-page\")")
  public String getNavigationStrategy() {
    return navigationStrategy;
  }

  public void setNavigationStrategy(String navigationStrategy) {
    this.navigationStrategy = navigationStrategy;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HighlightingResult highlightingResult = (HighlightingResult) o;
    return Objects.equals(this.success, highlightingResult.success) &&
        Objects.equals(this.cacheKey, highlightingResult.cacheKey) &&
        Objects.equals(this.documentUrl, highlightingResult.documentUrl) &&
        Objects.equals(this.highlightedPages, highlightingResult.highlightedPages) &&
        Objects.equals(this.pagesWithMatches, highlightingResult.pagesWithMatches) &&
        Objects.equals(this.highlightedTerms, highlightingResult.highlightedTerms) &&
        Objects.equals(this.navigationStrategy, highlightingResult.navigationStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, cacheKey, documentUrl, highlightedPages, pagesWithMatches, highlightedTerms, navigationStrategy);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HighlightingResult {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    cacheKey: ").append(toIndentedString(cacheKey)).append("\n");
    sb.append("    documentUrl: ").append(toIndentedString(documentUrl)).append("\n");
    sb.append("    highlightedPages: ").append(toIndentedString(highlightedPages)).append("\n");
    sb.append("    pagesWithMatches: ").append(toIndentedString(pagesWithMatches)).append("\n");
    sb.append("    highlightedTerms: ").append(toIndentedString(highlightedTerms)).append("\n");
    sb.append("    navigationStrategy: ").append(toIndentedString(navigationStrategy)).append("\n");
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

