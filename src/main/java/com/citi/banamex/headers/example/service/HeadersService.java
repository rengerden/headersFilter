package com.citi.banamex.headers.example.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * The interface Headers service.
 * 
 * @author Alfonso Chávez.
 *
 */
public interface HeadersService {

  /**
   * Retrieve all Headers in HttpServletRequest.
   * 
   * @param httpServletRequest.
   * @return header map and all their values in a list.
   */
  Map<String, List<String>> getAllHeaders(HttpServletRequest request);

  /**
   * Retrieve all Headers in HttpServletRequest request filtered by a list.
   * 
   * @param httpServletRequest .
   * @param headerNames is a list to filter.
   * @return header filtered map and all their values in a list.
   */
  Map<String, List<String>> getAllHeadersFiltered(HttpServletRequest request,
      List<String> headerNames);

}
