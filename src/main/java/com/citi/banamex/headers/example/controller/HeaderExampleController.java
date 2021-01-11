package com.citi.banamex.headers.example.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.citi.banamex.headers.example.service.HeadersService;

@RestController
@RequestMapping(value = "${constants.api.gralPath}")
public class HeaderExampleController {

  @Autowired
  HeadersService headersService;

  @GetMapping(value = "extraction")
  public ResponseEntity<Map<String, List<String>>> headersExtraction(HttpServletRequest request) {
    return new ResponseEntity<>(headersService.getAllHeaders(request), HttpStatus.OK);
  }

  @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, List<String>>> headersFilter(HttpServletRequest request,
      @RequestBody List<String> headerNames) {
    return new ResponseEntity<>(headersService.getAllHeadersFiltered(request, headerNames),
        HttpStatus.OK);
  }

}
