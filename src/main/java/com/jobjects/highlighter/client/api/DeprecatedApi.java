

package com.jobjects.highlighter.client.api;

import com.jobjects.highlighter.client.ApiCallback;
import com.jobjects.highlighter.client.ApiClient;
import com.jobjects.highlighter.client.ApiException;
import com.jobjects.highlighter.client.ApiResponse;
import com.jobjects.highlighter.client.Configuration;
import com.jobjects.highlighter.client.Pair;
import com.jobjects.highlighter.client.ProgressRequestBody;
import com.jobjects.highlighter.client.ProgressResponseBody;

import java.io.IOException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeprecatedApi {
    private ApiClient apiClient;

    public DeprecatedApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DeprecatedApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for docCacheKeyGet */
    private com.squareup.okhttp.Call docCacheKeyGetCall(String cacheKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'cacheKey' is set
        if (cacheKey == null) {
            throw new ApiException("Missing the required parameter 'cacheKey' when calling docCacheKeyGet(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/doc/{cacheKey}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "cacheKey" + "\\}", apiClient.escapeString(cacheKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
     * 
     * DEPRECATED: See /result-document 
     * @param cacheKey  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void docCacheKeyGet(String cacheKey) throws ApiException {
        docCacheKeyGetWithHttpInfo(cacheKey);
    }

    /**
     * 
     * DEPRECATED: See /result-document 
     * @param cacheKey  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> docCacheKeyGetWithHttpInfo(String cacheKey) throws ApiException {
        com.squareup.okhttp.Call call = docCacheKeyGetCall(cacheKey, null, null);
        return apiClient.execute(call);
    }

    /**
     *  (asynchronously)
     * DEPRECATED: See /result-document 
     * @param cacheKey  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call docCacheKeyGetAsync(String cacheKey, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = docCacheKeyGetCall(cacheKey, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
