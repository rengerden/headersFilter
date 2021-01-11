package com.citi.banamex.headers.example.constant;

import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
@EnableConfigurationProperties
@ConfigurationProperties
@Getter
public class ApiConstants implements Serializable {


  private static final long serialVersionUID = 5963539622027576665L;

  public static final String HEADERS_EXTRACTION_ROUTE = "${constants.api.extractionPath}";

  public static final String HEADERS_FILTER_ROUTE = "${constants.api.filterPath}";



}
