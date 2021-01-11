package com.citi.banamex.headers.example.service.impl;

import com.citi.banamex.headers.example.constant.ApiConstants;
import com.citi.banamex.headers.example.service.HeadersService;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

/**
 * Header filter example controller, set of endpoints to extract or filter headers.
 * 
 * @author Alfonso Chávez.
 *
 */
@Service
public class HeadersServiceImpl implements HeadersService {

  /**
   * method to get all headers within HttpServletRequest.
   * 
   * @param request the HttpServletRequest request.
   * @return header map and all their values in a list.
   * 
   */
  @Override
  public Map<String, List<String>> getAllHeaders(HttpServletRequest request) {
    return Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(
        Function.identity(), s -> Arrays.asList(request.getHeader(s).split(ApiConstants.COMMA))));
  }

  /**
   * method to get headers within HttpServletRequest filtered by a list sent by the user.
   * 
   * @param request the HttpServletRequest request.
   * @param header names to filter.
   * @return header filtered map and all their values in a list.
   * 
   */
  @Override
  public Map<String, List<String>> getAllHeadersFiltered(HttpServletRequest request,
      List<String> headerNames) {
    return Collections.list(request.getHeaderNames()).stream()
        .filter(f -> headerNames.stream().anyMatch(f::equals))
        .collect(Collectors.toMap(Function.identity(),
            s -> Arrays.asList(request.getHeader(s).split(ApiConstants.COMMA))));
  }

}
