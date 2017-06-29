package com.jobjects.highlighter;

import com.jobjects.highlighter.client.ApiException;
import com.jobjects.highlighter.client.api.AuxApi;
import com.jobjects.highlighter.client.model.ExtractResult;
import com.jobjects.highlighter.client.model.PageItem;

import java.io.*;
import java.util.List;

/**
 * Created by jobjects on 5/8/17.
 */
public class ExtractText {

  public static void main(String[] args) throws IOException {
    if (args.length != 3) {
      usage();
      return;
    }

    String hlServer = args[0];
    String docUri = args[1];
    String txtFile = args[2];

    AuxApi apiInstance = new AuxApi(hlServer);
    Writer out = null;
    try {

      //apiInstance.getApiClient().bui

      ExtractResult result = apiInstance.extractDocument(docUri);
      if (result.getSuccess() != null && result.getSuccess()) {
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFile), "UTF-8"));
        List<PageItem> pages = result.getPages();
        for (PageItem page: pages) {
          out.write(page.getContent());
          System.err.println("Page #" + page.getPage() + ": " + page.getLength() + " chars");
        }
      } else {
        System.err.println("Text extraction failed.");
      }

    } catch (ApiException e) {
      System.err.println("Exception when extracting text.");
      // fixme print e details
      e.printStackTrace();
    } finally {
      if (out != null) {
        out.close();
      }
    }

  }

  private static void usage()
  {
    System.err.println("Usage: java " + ExtractText.class.getName() + " <highlighter-server-url> <input-pdf> <output-txt>");
  }

}