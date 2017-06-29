package com.jobjects.highlighter.client.api;

import com.jobjects.highlighter.client.ApiException;
import org.junit.Test;

/**
 * API tests for AuxApi
 */
public class AuxApiTest {

    private final AuxApi api = new AuxApi();

    
    /**
     * emails highlighted document
     *
     * Send an email with highlighted document. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void emailDocumentTest() throws ApiException {
        String doc = null;
        String from = null;
        String to = null;
        String subject = null;
        String message = null;
        Boolean highlightTerms = null;
        Boolean removePagesWithoutMatches = null;
        // EmailSendResponse response = api.emailDocument(doc, from, to, subject, message, highlightTerms, removePagesWithoutMatches);

        // TODO: test validations
    }
    
    /**
     * extract text for document
     *
     * Indexes PDF document referenced by \&quot;uri\&quot; and returns extracted text. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void extractDocumentTest() throws ApiException {
        String uri = null;
        Boolean filtered = null;
        Boolean skipCache = null;
        // ExtractResult response = api.extractDocument(uri, filtered, skipCache);

        // TODO: test validations
    }
    
    /**
     * extract text for uploaded document
     *
     * Indexes PDF document uploaded in the request body and returns extracted text. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void extractUploadedDocumentTest() throws ApiException {
        String uri = null;
        String modTime = null;
        Boolean filtered = null;
        Boolean skipCache = null;
        // ExtractResult response = api.extractUploadedDocument(uri, modTime, filtered, skipCache);

        // TODO: test validations
    }
    
    /**
     * returns original document
     *
     * Returns original document identified by the document key. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCachedDocumentTest() throws ApiException {
        String docId = null;
        String altUrl = null;
        // api.getCachedDocument(docId, altUrl);

        // TODO: test validations
    }
    
    /**
     * returns matching text info
     *
     * Returns details about matching text for use by PDF Highlighting Viewer. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getHitsTest() throws ApiException {
        String cacheKey = null;
        // api.getHits(cacheKey);

        // TODO: test validations
    }
    
    /**
     * returns highlighted document
     *
     * Returns highlighting result (PDF with highlights \&quot;burned\&quot; into PDF) identified by the cache key. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getResultDocumentTest() throws ApiException {
        String cacheKey = null;
        String altUrl = null;
        // api.getResultDocument(cacheKey, altUrl);

        // TODO: test validations
    }
    
    /**
     * highlighting service status
     *
     * Returns PDF Highlighter server status.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStatusTest() throws ApiException {
        // ServerStatus response = api.getStatus();

        // TODO: test validations
    }
    
    /**
     * index document
     *
     * Indexes PDF document referenced by \&quot;uri\&quot;. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void indexDocumentTest() throws ApiException {
        String uri = null;
        Boolean filtered = null;
        Boolean skipCache = null;
        // IndexingResult response = api.indexDocument(uri, filtered, skipCache);

        // TODO: test validations
    }
    
    /**
     * index uploaded document
     *
     * Indexes PDF document uploaded in the request body. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void indexUploadedDocumentTest() throws ApiException {
        String uri = null;
        String modTime = null;
        Boolean filtered = null;
        Boolean skipCache = null;
        // IndexingResult response = api.indexUploadedDocument(uri, modTime, filtered, skipCache);

        // TODO: test validations
    }
    
}
