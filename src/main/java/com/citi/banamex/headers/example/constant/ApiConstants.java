package com.citi.banamex.headers.example.constant;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Api Constants for Controller class.
 * 
 * @author Alfonso Chávez.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class ApiConstants implements Serializable {

  /**
   * field to UID Serialization.
   */
  private static final long serialVersionUID = 5963539622027576665L;

  /**
   * Constant route for extraction headers.
   */
  public static final String HEADERS_EXTRACTION_ROUTE = "${constants.api.extractionPath}";

  /**
   * Constant route for filter headers.
   */
  public static final String HEADERS_FILTER_ROUTE = "${constants.api.filterPath}";

  /**
   * Constant comma use for split string.
   */
  public static final String COMMA = ",";

}
