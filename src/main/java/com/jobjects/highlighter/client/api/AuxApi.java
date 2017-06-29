

package com.jobjects.highlighter.client.api;

import com.google.gson.reflect.TypeToken;
import com.jobjects.highlighter.client.*;
import com.jobjects.highlighter.client.model.EmailSendResponse;
import com.jobjects.highlighter.client.model.ExtractResult;
import com.jobjects.highlighter.client.model.IndexingResult;
import com.jobjects.highlighter.client.model.ServerStatus;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuxApi {
    private ApiClient apiClient;

    public AuxApi(String basePath) {
        this(Configuration.getDefaultApiClient().setBasePath(basePath).setConnectTimeout(20000)); // fixme
    }

    public AuxApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AuxApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for emailDocument */
    private com.squareup.okhttp.Call emailDocumentCall(String doc, String from, String to, String subject, String message, Boolean highlightTerms, Boolean removePagesWithoutMatches, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'doc' is set
        if (doc == null) {
            throw new ApiException("Missing the required parameter 'doc' when calling emailDocument(Async)");
        }
        
        // verify the required parameter 'from' is set
        if (from == null) {
            throw new ApiException("Missing the required parameter 'from' when calling emailDocument(Async)");
        }
        
        // verify the required parameter 'to' is set
        if (to == null) {
            throw new ApiException("Missing the required parameter 'to' when calling emailDocument(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/email".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (doc != null)
        localVarFormParams.put("doc", doc);
        if (from != null)
        localVarFormParams.put("from", from);
        if (to != null)
        localVarFormParams.put("to", to);
        if (subject != null)
        localVarFormParams.put("subject", subject);
        if (message != null)
        localVarFormParams.put("message", message);
        if (highlightTerms != null)
        localVarFormParams.put("highlightTerms", highlightTerms);
        if (removePagesWithoutMatches != null)
        localVarFormParams.put("removePagesWithoutMatches", removePagesWithoutMatches);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * emails highlighted document
     * Send an email with highlighted document. 
     * @param doc Document ID (required)
     * @param from Sender email address. Not required if sender is enforced by the server configuration. (required)
     * @param to Recipient email addresses. Multiple email addresses can be listed separated by white space. (required)
     * @param subject Email subject (optional)
     * @param message Message body (optional)
     * @param highlightTerms If enabled, emailed document will have search terms highlighted. (optional, default to true)
     * @param removePagesWithoutMatches If enabled, enabled document will have only pages containing search terms. (optional, default to false)
     * @return EmailSendResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmailSendResponse emailDocument(String doc, String from, String to, String subject, String message, Boolean highlightTerms, Boolean removePagesWithoutMatches) throws ApiException {
        ApiResponse<EmailSendResponse> resp = emailDocumentWithHttpInfo(doc, from, to, subject, message, highlightTerms, removePagesWithoutMatches);
        return resp.getData();
    }

    /**
     * emails highlighted document
     * Send an email with highlighted document. 
     * @param doc Document ID (required)
     * @param from Sender email address. Not required if sender is enforced by the server configuration. (required)
     * @param to Recipient email addresses. Multiple email addresses can be listed separated by white space. (required)
     * @param subject Email subject (optional)
     * @param message Message body (optional)
     * @param highlightTerms If enabled, emailed document will have search terms highlighted. (optional, default to true)
     * @param removePagesWithoutMatches If enabled, enabled document will have only pages containing search terms. (optional, default to false)
     * @return ApiResponse&lt;EmailSendResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmailSendResponse> emailDocumentWithHttpInfo(String doc, String from, String to, String subject, String message, Boolean highlightTerms, Boolean removePagesWithoutMatches) throws ApiException {
        com.squareup.okhttp.Call call = emailDocumentCall(doc, from, to, subject, message, highlightTerms, removePagesWithoutMatches, null, null);
        Type localVarReturnType = new TypeToken<EmailSendResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * emails highlighted document (asynchronously)
     * Send an email with highlighted document. 
     * @param doc Document ID (required)
     * @param from Sender email address. Not required if sender is enforced by the server configuration. (required)
     * @param to Recipient email addresses. Multiple email addresses can be listed separated by white space. (required)
     * @param subject Email subject (optional)
     * @param message Message body (optional)
     * @param highlightTerms If enabled, emailed document will have search terms highlighted. (optional, default to true)
     * @param removePagesWithoutMatches If enabled, enabled document will have only pages containing search terms. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call emailDocumentAsync(String doc, String from, String to, String subject, String message, Boolean highlightTerms, Boolean removePagesWithoutMatches, final ApiCallback<EmailSendResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = emailDocumentCall(doc, from, to, subject, message, highlightTerms, removePagesWithoutMatches, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmailSendResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for extractDocument */
    private com.squareup.okhttp.Call extractDocumentCall(String uri, Boolean filtered, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/extract".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (filtered != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filtered", filtered));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * extract text for document
     * Indexes PDF document referenced by \&quot;uri\&quot; and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @return ExtractResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtractResult extractDocument(String uri) throws ApiException {
        ApiResponse<ExtractResult> resp = extractDocumentWithHttpInfo(uri, null, null);
        return resp.getData();
    }

    /**
     * extract text for document
     * Indexes PDF document referenced by \&quot;uri\&quot; and returns extracted text.
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ExtractResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtractResult extractDocument(String uri, Boolean filtered, Boolean skipCache) throws ApiException {
        ApiResponse<ExtractResult> resp = extractDocumentWithHttpInfo(uri, filtered, skipCache);
        return resp.getData();
    }

    /**
     * extract text for document
     * Indexes PDF document referenced by \&quot;uri\&quot; and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ApiResponse&lt;ExtractResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ExtractResult> extractDocumentWithHttpInfo(String uri, Boolean filtered, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = extractDocumentCall(uri, filtered, skipCache, null, null);
        Type localVarReturnType = new TypeToken<ExtractResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * extract text for document (asynchronously)
     * Indexes PDF document referenced by \&quot;uri\&quot; and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call extractDocumentAsync(String uri, Boolean filtered, Boolean skipCache, final ApiCallback<ExtractResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = extractDocumentCall(uri, filtered, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtractResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for extractUploadedDocument */
    private com.squareup.okhttp.Call extractUploadedDocumentCall(String uri, String modTime, Boolean filtered, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/extract".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (modTime != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "modTime", modTime));
        if (filtered != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filtered", filtered));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/pdf"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * extract text for uploaded document
     * Indexes PDF document uploaded in the request body and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ExtractResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtractResult extractUploadedDocument(String uri, String modTime, Boolean filtered, Boolean skipCache) throws ApiException {
        ApiResponse<ExtractResult> resp = extractUploadedDocumentWithHttpInfo(uri, modTime, filtered, skipCache);
        return resp.getData();
    }

    /**
     * extract text for uploaded document
     * Indexes PDF document uploaded in the request body and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ApiResponse&lt;ExtractResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ExtractResult> extractUploadedDocumentWithHttpInfo(String uri, String modTime, Boolean filtered, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = extractUploadedDocumentCall(uri, modTime, filtered, skipCache, null, null);
        Type localVarReturnType = new TypeToken<ExtractResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * extract text for uploaded document (asynchronously)
     * Indexes PDF document uploaded in the request body and returns extracted text. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call extractUploadedDocumentAsync(String uri, String modTime, Boolean filtered, Boolean skipCache, final ApiCallback<ExtractResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = extractUploadedDocumentCall(uri, modTime, filtered, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtractResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getCachedDocument */
    private com.squareup.okhttp.Call getCachedDocumentCall(String docId, String altUrl, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'docId' is set
        if (docId == null) {
            throw new ApiException("Missing the required parameter 'docId' when calling getCachedDocument(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/cached-document/{docId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "docId" + "\\}", apiClient.escapeString(docId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (altUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "altUrl", altUrl));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/pdf"
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
     * returns original document
     * Returns original document identified by the document key. 
     * @param docId Highlighter generated document identifier. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void getCachedDocument(String docId, String altUrl) throws ApiException {
        getCachedDocumentWithHttpInfo(docId, altUrl);
    }

    /**
     * returns original document
     * Returns original document identified by the document key. 
     * @param docId Highlighter generated document identifier. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> getCachedDocumentWithHttpInfo(String docId, String altUrl) throws ApiException {
        com.squareup.okhttp.Call call = getCachedDocumentCall(docId, altUrl, null, null);
        return apiClient.execute(call);
    }

    /**
     * returns original document (asynchronously)
     * Returns original document identified by the document key. 
     * @param docId Highlighter generated document identifier. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCachedDocumentAsync(String docId, String altUrl, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCachedDocumentCall(docId, altUrl, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getHits */
    private com.squareup.okhttp.Call getHitsCall(String cacheKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'cacheKey' is set
        if (cacheKey == null) {
            throw new ApiException("Missing the required parameter 'cacheKey' when calling getHits(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/hits/{cacheKey}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "cacheKey" + "\\}", apiClient.escapeString(cacheKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
     * returns matching text info
     * Returns details about matching text for use by PDF Highlighting Viewer. 
     * @param cacheKey Highlighting result cache key. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void getHits(String cacheKey) throws ApiException {
        getHitsWithHttpInfo(cacheKey);
    }

    /**
     * returns matching text info
     * Returns details about matching text for use by PDF Highlighting Viewer. 
     * @param cacheKey Highlighting result cache key. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> getHitsWithHttpInfo(String cacheKey) throws ApiException {
        com.squareup.okhttp.Call call = getHitsCall(cacheKey, null, null);
        return apiClient.execute(call);
    }

    /**
     * returns matching text info (asynchronously)
     * Returns details about matching text for use by PDF Highlighting Viewer. 
     * @param cacheKey Highlighting result cache key. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getHitsAsync(String cacheKey, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getHitsCall(cacheKey, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getResultDocument */
    private com.squareup.okhttp.Call getResultDocumentCall(String cacheKey, String altUrl, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'cacheKey' is set
        if (cacheKey == null) {
            throw new ApiException("Missing the required parameter 'cacheKey' when calling getResultDocument(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/result-document/{cacheKey}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "cacheKey" + "\\}", apiClient.escapeString(cacheKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (altUrl != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "altUrl", altUrl));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/pdf"
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
     * returns highlighted document
     * Returns highlighting result (PDF with highlights \&quot;burned\&quot; into PDF) identified by the cache key. 
     * @param cacheKey Highlighting result cache key. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void getResultDocument(String cacheKey, String altUrl) throws ApiException {
        getResultDocumentWithHttpInfo(cacheKey, altUrl);
    }

    /**
     * returns highlighted document
     * Returns highlighting result (PDF with highlights \&quot;burned\&quot; into PDF) identified by the cache key. 
     * @param cacheKey Highlighting result cache key. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> getResultDocumentWithHttpInfo(String cacheKey, String altUrl) throws ApiException {
        com.squareup.okhttp.Call call = getResultDocumentCall(cacheKey, altUrl, null, null);
        return apiClient.execute(call);
    }

    /**
     * returns highlighted document (asynchronously)
     * Returns highlighting result (PDF with highlights \&quot;burned\&quot; into PDF) identified by the cache key. 
     * @param cacheKey Highlighting result cache key. (required)
     * @param altUrl If the method was triggered by direct link but request cannot be fulfilled (e.g. cache expired or some error occurred), user will be redirected to URL specified by this parameter. For highlighting requests this defaults to &#39;uri&#39; input parameter. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResultDocumentAsync(String cacheKey, String altUrl, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getResultDocumentCall(cacheKey, altUrl, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getStatus */
    private com.squareup.okhttp.Call getStatusCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/status".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
     * highlighting service status
     * Returns PDF Highlighter server status.
     * @return ServerStatus
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerStatus getStatus() throws ApiException {
        ApiResponse<ServerStatus> resp = getStatusWithHttpInfo();
        return resp.getData();
    }

    /**
     * highlighting service status
     * Returns PDF Highlighter server status.
     * @return ApiResponse&lt;ServerStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerStatus> getStatusWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getStatusCall(null, null);
        Type localVarReturnType = new TypeToken<ServerStatus>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * highlighting service status (asynchronously)
     * Returns PDF Highlighter server status.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getStatusAsync(final ApiCallback<ServerStatus> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getStatusCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerStatus>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for indexDocument */
    private com.squareup.okhttp.Call indexDocumentCall(String uri, Boolean filtered, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/index".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (filtered != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filtered", filtered));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * index document
     * Indexes PDF document referenced by \&quot;uri\&quot;. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return IndexingResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IndexingResult indexDocument(String uri, Boolean filtered, Boolean skipCache) throws ApiException {
        ApiResponse<IndexingResult> resp = indexDocumentWithHttpInfo(uri, filtered, skipCache);
        return resp.getData();
    }

    /**
     * index document
     * Indexes PDF document referenced by \&quot;uri\&quot;. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ApiResponse&lt;IndexingResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IndexingResult> indexDocumentWithHttpInfo(String uri, Boolean filtered, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = indexDocumentCall(uri, filtered, skipCache, null, null);
        Type localVarReturnType = new TypeToken<IndexingResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * index document (asynchronously)
     * Indexes PDF document referenced by \&quot;uri\&quot;. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call indexDocumentAsync(String uri, Boolean filtered, Boolean skipCache, final ApiCallback<IndexingResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = indexDocumentCall(uri, filtered, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IndexingResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for indexUploadedDocument */
    private com.squareup.okhttp.Call indexUploadedDocumentCall(String uri, String modTime, Boolean filtered, Boolean skipCache, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/index".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (uri != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "uri", uri));
        if (modTime != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "modTime", modTime));
        if (filtered != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filtered", filtered));
        if (skipCache != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCache", skipCache));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/pdf"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * index uploaded document
     * Indexes PDF document uploaded in the request body. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return IndexingResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IndexingResult indexUploadedDocument(String uri, String modTime, Boolean filtered, Boolean skipCache) throws ApiException {
        ApiResponse<IndexingResult> resp = indexUploadedDocumentWithHttpInfo(uri, modTime, filtered, skipCache);
        return resp.getData();
    }

    /**
     * index uploaded document
     * Indexes PDF document uploaded in the request body. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @return ApiResponse&lt;IndexingResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IndexingResult> indexUploadedDocumentWithHttpInfo(String uri, String modTime, Boolean filtered, Boolean skipCache) throws ApiException {
        com.squareup.okhttp.Call call = indexUploadedDocumentCall(uri, modTime, filtered, skipCache, null, null);
        Type localVarReturnType = new TypeToken<IndexingResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * index uploaded document (asynchronously)
     * Indexes PDF document uploaded in the request body. 
     * @param uri Document \&quot;uri\&quot; as will be referenced by highlighting requests. (optional)
     * @param modTime Document timestamp in http format (\&quot;EEE, dd MMM yyyy HH:mm:ss zzz\&quot;) (optional)
     * @param filtered Pass extracted text through custom filter. (optional, default to false)
     * @param skipCache Force re-indexing even if document didn&#39;t change. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call indexUploadedDocumentAsync(String uri, String modTime, Boolean filtered, Boolean skipCache, final ApiCallback<IndexingResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = indexUploadedDocumentCall(uri, modTime, filtered, skipCache, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IndexingResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
