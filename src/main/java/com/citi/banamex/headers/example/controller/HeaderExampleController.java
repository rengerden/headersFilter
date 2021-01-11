package com.citi.banamex.headers.example.controller;

import com.citi.banamex.headers.example.constant.ApiConstants;
import com.citi.banamex.headers.example.service.HeadersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Example to filter a extract Headers controller.
 * 
 * @author Alfonso Chávez.
 *
 */
@RestController
@RequestMapping(value = "${constants.api.gralPath}")
public class HeaderExampleController {

  /**
   * Headers Service.
   */
  @Autowired
  HeadersService headersService;

  /**
   * Rest GET to retrieve all headers in httpServletRequest.
   * 
   * @param httpServletRequest.
   * @return header map and all their values in a list.
   */
  @GetMapping(value = ApiConstants.HEADERS_EXTRACTION_ROUTE)
  public ResponseEntity<Map<String, List<String>>> headersExtraction(HttpServletRequest request) {
    return new ResponseEntity<>(headersService.getAllHeaders(request), HttpStatus.OK);
  }

  /**
   * Rest POST to retrieve all headers in httpServletRequest filtered by a list sent by user.
   * 
   * @param httpServletRequest.
   * @param headerNames is a list to filter headers.
   * @return header filtered map and all their values in a list.
   */
  @PostMapping(value = ApiConstants.HEADERS_FILTER_ROUTE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, List<String>>> headersFilter(HttpServletRequest request,
      @RequestBody List<String> headerNames) {
    return new ResponseEntity<>(headersService.getAllHeadersFiltered(request, headerNames),
        HttpStatus.OK);
  }

}
