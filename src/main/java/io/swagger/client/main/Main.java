package io.swagger.client.main;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ConnectionApi;
import io.swagger.client.model.Connection;
import io.swagger.client.model.ConnectionCollection;
import io.swagger.client.model.ConnectionTest;
import java.sql.SQLOutput;

/**
 * @author <a href="mailto:<vasco.ventura@xpand-it.com>"><Vasco Ventura></a>
 * @version $Revision: 666 $
 */

public class Main {
  public static void main(String []args) {

    ConnectionApi apiInstance = new ConnectionApi();
    ConnectionTest result;
    Connection body = new Connection();


    {
      try {
        result = apiInstance.testConnection(body);
        System.out.println(result);
      } catch (ApiException e) {
        System.err.println("Exception when calling ConnectionApi#testConnection");
        e.printStackTrace();
      }
    }
  }

}