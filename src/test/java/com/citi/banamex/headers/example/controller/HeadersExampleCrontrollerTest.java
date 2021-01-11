package com.citi.banamex.headers.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import com.citi.banamex.headers.example.service.HeadersService;

/**
 * Example to filter a extract Headers controller test.
 * 
 * @author Alfonso Chávez.
 *
 */
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
class HeadersExampleCrontrollerTest {

  /**
   * Headers Service injection is a mock.
   */
  @Mock
  HeadersService headersService;

  /**
   * Header Example Controller injection for coverage.
   */
  @InjectMocks
  HeaderExampleController headerExampleController;

  /**
   * Mock of HttpServletRequest.
   */
  MockHttpServletRequest request;

  /**
   * Map expected in a correct response.
   */
  Map<String, List<String>> mapExpected;

  /**
   * Filter list of headers names.
   */
  List<String> headerNames;

  /**
   * Number Http status of correct response.
   */
  private final static int OK = 200;

  /**
   * Initializing of mockito.
   */
  @BeforeEach
  public void init() {
    request = new MockHttpServletRequest();
    request.addHeader("uuid",
        "dfe7a304-86ca-4cc8-8d85-92cf731d659e,28fc459a-1dc9-4c14-92ac-1f253a300f4f");

    mapExpected = new HashMap<>();

    List<String> uuidList = new ArrayList<>();
    uuidList.add("dfe7a304-86ca-4cc8-8d85-92cf731d659e");
    uuidList.add("28fc459a-1dc9-4c14-92ac-1f253a300f4f");

    mapExpected.put("uuid", uuidList);
    List<String> headerNames = new ArrayList<>();
    headerNames.add("uuid");
  }

  /**
   * Test for extract all headers.
   * 
   */
  @Test
  @DisplayName("Header extraction Test")
  public void headersExtractionTest() {
    when(headersService.getAllHeaders(request)).thenReturn(mapExpected);

    ResponseEntity<Map<String, List<String>>> httpResponse =
        headerExampleController.headersExtraction(request);

    assertEquals(OK, httpResponse.getStatusCodeValue());

    assertEquals(mapExpected, httpResponse.getBody());
  }

  /**
   * Test for retrieve filtered headers by list.
   */
  @Test
  @DisplayName("Header filter Test")
  public void headersFilterTest() {
    when(headersService.getAllHeadersFiltered(request, headerNames)).thenReturn(mapExpected);
    ResponseEntity<Map<String, List<String>>> httpResponse =
        headerExampleController.headersFilter(request, headerNames);

    assertEquals(OK, httpResponse.getStatusCodeValue());

    assertEquals(mapExpected, httpResponse.getBody());

  }

}
