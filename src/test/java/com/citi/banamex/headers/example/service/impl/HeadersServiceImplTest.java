package com.citi.banamex.headers.example.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Test of Header service implementation class.
 * 
 * @author Alfonso Chávez.
 *
 */
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
class HeadersServiceImplTest {
  
  /**
   *  Headers service implementation for coverage.
   */
  @InjectMocks
  HeadersServiceImpl headersServiceImpl;

  /**
   * Mock of HttpServletRequest.
   */
  MockHttpServletRequest request;

  /**
   * Map expected in a correct response.
   */
  Map<String, List<String>> mapExtractedExpected;

  /**
   * Map filtered expected in a correct response.
   */
  Map<String, List<String>> mapFilteredExpected;

  /**
   * Filter list of headers names.
   */
  List<String> headerNames;

  /**
   * Initializing of mockito.
   */
  @BeforeEach
  public void init() {
    request = new MockHttpServletRequest();
    request.addHeader("uuid",
        "dfe7a304-86ca-4cc8-8d85-92cf731d659e,28fc459a-1dc9-4c14-92ac-1f253a300f4f");

    mapExtractedExpected = new HashMap<>();

    List<String> uuidList = new ArrayList<>();
    uuidList.add("dfe7a304-86ca-4cc8-8d85-92cf731d659e");
    uuidList.add("28fc459a-1dc9-4c14-92ac-1f253a300f4f");

    mapExtractedExpected.put("uuid", uuidList);

    headerNames = new ArrayList<>();
    headerNames.add("uuid");
  }

  /**
   * Test of method to retrieve all headers in a httpServletRequest.
   */
  @Test
  void getAllHeadersTest() {
    Map<String, List<String>> mapResponse = headersServiceImpl.getAllHeaders(request);
    assertEquals(mapExtractedExpected, mapResponse);
  }

  /**
   * Test of method to retrieve all headers filtered by a list sent by user in a httpServletRequest.
   */
  @Test
  void getAllHeadersFiltered() {
    Map<String, List<String>> mapResponse =
        headersServiceImpl.getAllHeadersFiltered(request, headerNames);
    assertEquals(mapExtractedExpected, mapResponse);
  }


}
