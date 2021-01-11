package com.citi.banamex.headers.example.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface HeadersService {

  Map<String, List<String>> getAllHeaders(HttpServletRequest request);

  Map<String, List<String>> getAllHeadersFiltered(HttpServletRequest request,
      List<String> headerNames);

}
