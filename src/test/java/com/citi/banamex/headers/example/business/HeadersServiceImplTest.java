package com.citi.banamex.headers.example.business;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;

@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
class HeadersServiceImplTest {

  @InjectMocks
  HeadersServiceImpl headersServiceImpl;

  MockHttpServletRequest request;

  Map<String, List<String>> mapExtractedExpected;

  Map<String, List<String>> mapFilteredExpected;

  List<String> headerNames;

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

  @Test
  void getAllHeadersTest() {
    Map<String, List<String>> mapResponse = headersServiceImpl.getAllHeaders(request);
    assertEquals(mapExtractedExpected, mapResponse);
  }

  @Test
  void getAllHeadersFiltered() {
    Map<String, List<String>> mapResponse =
        headersServiceImpl.getAllHeadersFiltered(request, headerNames);
    assertEquals(mapExtractedExpected, mapResponse);
  }


}
