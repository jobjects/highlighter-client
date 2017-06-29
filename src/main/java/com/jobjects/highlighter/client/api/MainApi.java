

package com.jobjects.highlighter.client.api;

import com.jobjects.highlighter.client.model.HighlightingResult;
import com.jobjects.highlighter.client.ApiCallback;
import com.jobjects.highlighter.client.ApiClient;
import com.jobjects.highlighter.client.ApiException;
import com.jobjects.highlighter.client.ApiResponse;
import com.jobjects.highlighter.client.Configuration;
import com.jobjects.highlighter.client.Pair;
import com.jobjects.highlighter.client.ProgressRequestBody;
import com.jobjects.highlighter.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApi {
    private ApiClient apiClient;

    public MainApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MainApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for highlightForQuery */
    private com.squareup.okhttp.Call highlightForQueryCall(String uri, String query, String language, String pageHints, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'uri' is set
        if (uri == null) {
            throw new ApiException("Missing the required parameter 'uri' when calling highlightForQuery(Async)");
        }
        
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new ApiException("Missing the required parameter 'query' when calling highlightForQuery(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/highlight-for-query".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (query != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
        if (language != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));
        if (pageHints != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageHints", pageHints));
        if (addNavigation != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addNavigation", addNavigation));
        if (openFirstHlPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "openFirstHlPage", openFirstHlPage));
        if (removePagesWithoutMatches != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "removePagesWithoutMatches", removePagesWithoutMatches));
        if (neighbourPages != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "neighbourPages", neighbourPages));
        if (altUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "altUrl", altUrl));
        if (documentServingPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "documentServingPath", documentServingPath));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/pdf"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * highlights PDF document for search query
     * Highlights PDF document for provided query string. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param query Query string. (required)
     * @param language Code of the language to use for text analysis. Instead of specifying language in query, it&#39;s recommended to setup language and indexing in the config file. (optional)
     * @param pageHints Comma separated list of PDF document pages to highlight. Use this if your search solution already provides matching pages. If not specified, PDF Highlighter will use internal search engine. (optional)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @return HighlightingResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HighlightingResult highlightForQuery(String uri, String query, String language, String pageHints, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache) throws ApiException {
        ApiResponse<HighlightingResult> resp = highlightForQueryWithHttpInfo(uri, query, language, pageHints, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache);
        return resp.getData();
    }

    /**
     * highlights PDF document for search query
     * Highlights PDF document for provided query string. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param query Query string. (required)
     * @param language Code of the language to use for text analysis. Instead of specifying language in query, it&#39;s recommended to setup language and indexing in the config file. (optional)
     * @param pageHints Comma separated list of PDF document pages to highlight. Use this if your search solution already provides matching pages. If not specified, PDF Highlighter will use internal search engine. (optional)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @return ApiResponse&lt;HighlightingResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<HighlightingResult> highlightForQueryWithHttpInfo(String uri, String query, String language, String pageHints, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = highlightForQueryCall(uri, query, language, pageHints, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache, null, null);
        Type localVarReturnType = new TypeToken<HighlightingResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * highlights PDF document for search query (asynchronously)
     * Highlights PDF document for provided query string. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param query Query string. (required)
     * @param language Code of the language to use for text analysis. Instead of specifying language in query, it&#39;s recommended to setup language and indexing in the config file. (optional)
     * @param pageHints Comma separated list of PDF document pages to highlight. Use this if your search solution already provides matching pages. If not specified, PDF Highlighter will use internal search engine. (optional)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call highlightForQueryAsync(String uri, String query, String language, String pageHints, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache, final ApiCallback<HighlightingResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = highlightForQueryCall(uri, query, language, pageHints, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HighlightingResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for highlightForXml */
    private com.squareup.okhttp.Call highlightForXmlCall(String uri, String xml, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'uri' is set
        if (uri == null) {
            throw new ApiException("Missing the required parameter 'uri' when calling highlightForXml(Async)");
        }
        
        // verify the required parameter 'xml' is set
        if (xml == null) {
            throw new ApiException("Missing the required parameter 'xml' when calling highlightForXml(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/highlight-for-xml".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (xml != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "xml", xml));
        if (addNavigation != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "addNavigation", addNavigation));
        if (openFirstHlPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "openFirstHlPage", openFirstHlPage));
        if (removePagesWithoutMatches != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "removePagesWithoutMatches", removePagesWithoutMatches));
        if (neighbourPages != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "neighbourPages", neighbourPages));
        if (altUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "altUrl", altUrl));
        if (documentServingPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "documentServingPath", documentServingPath));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/pdf"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * highlights PDF document for Adobe Highlights File
     * Highlights PDF document using Adobe PDF Highlight XML provided by your search engine. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param xml URL providing Adobe Highlights or the content of highlights file included inline. (required)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @return HighlightingResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public HighlightingResult highlightForXml(String uri, String xml, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache) throws ApiException {
        ApiResponse<HighlightingResult> resp = highlightForXmlWithHttpInfo(uri, xml, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache);
        return resp.getData();
    }

    /**
     * highlights PDF document for Adobe Highlights File
     * Highlights PDF document using Adobe PDF Highlight XML provided by your search engine. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param xml URL providing Adobe Highlights or the content of highlights file included inline. (required)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @return ApiResponse&lt;HighlightingResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<HighlightingResult> highlightForXmlWithHttpInfo(String uri, String xml, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = highlightForXmlCall(uri, xml, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache, null, null);
        Type localVarReturnType = new TypeToken<HighlightingResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * highlights PDF document for Adobe Highlights File (asynchronously)
     * Highlights PDF document using Adobe PDF Highlight XML provided by your search engine. 
     * @param uri URI to file to highlight. Depending on server settings it can be specified as as file system path, URL transformed to file system path or URL to be fetched.  (required)
     * @param xml URL providing Adobe Highlights or the content of highlights file included inline. (required)
     * @param addNavigation When enabled, hit navigation will be injected into PDF. (Applies to burned PDF generation only.) (optional, default to true)
     * @param openFirstHlPage When enabled, PDF document will automatically open the first highlighted page. (Applies to burned PDF generation only.) (optional, default to true)
     * @param removePagesWithoutMatches When enabled, pages without matches will be removed from the PDF. (Applies to burned PDF generation only.) (optional, default to false)
     * @param neighbourPages Specifies number of naighbour pages (of pages with hits) to keep when &#39;removePagesWithoutMatches&#39; is enabled. (optional, default to 0)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param documentServingPath Overrides config file rules for choosing highlights delivery method (e.g. checking browser and accept http header). (optional)
     * @param skipCache Force highlighting even if there&#39;s cached result. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call highlightForXmlAsync(String uri, String xml, Boolean addNavigation, Boolean openFirstHlPage, Boolean removePagesWithoutMatches, Integer neighbourPages, String altUrl, String documentServingPath, Boolean skipCache, final ApiCallback<HighlightingResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = highlightForXmlCall(uri, xml, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<HighlightingResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
