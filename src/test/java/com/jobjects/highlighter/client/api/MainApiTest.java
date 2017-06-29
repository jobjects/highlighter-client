package com.jobjects.highlighter.client.api;

import com.jobjects.highlighter.client.ApiException;
import org.junit.Test;

/**
 * API tests for MainApi
 */
public class MainApiTest {

    private final MainApi api = new MainApi();

    
    /**
     * highlights PDF document for search query
     *
     * Highlights PDF document for provided query string. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void highlightForQueryTest() throws ApiException {
        String uri = null;
        String query = null;
        String language = null;
        String pageHints = null;
        Boolean addNavigation = null;
        Boolean openFirstHlPage = null;
        Boolean removePagesWithoutMatches = null;
        Integer neighbourPages = null;
        String altUrl = null;
        String documentServingPath = null;
        Boolean skipCache = null;
        // HighlightingResult response = api.highlightForQuery(uri, query, language, pageHints, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache);

        // TODO: test validations
    }
    
    /**
     * highlights PDF document for Adobe Highlights File
     *
     * Highlights PDF document using Adobe PDF Highlight XML provided by your search engine. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void highlightForXmlTest() throws ApiException {
        String uri = null;
        String xml = null;
        Boolean addNavigation = null;
        Boolean openFirstHlPage = null;
        Boolean removePagesWithoutMatches = null;
        Integer neighbourPages = null;
        String altUrl = null;
        String documentServingPath = null;
        Boolean skipCache = null;
        // HighlightingResult response = api.highlightForXml(uri, xml, addNavigation, openFirstHlPage, removePagesWithoutMatches, neighbourPages, altUrl, documentServingPath, skipCache);

        // TODO: test validations
    }
    
}
