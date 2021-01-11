package com.citi.banamex.headers.example.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.citi.banamex.headers.example.constant.Constants;
import com.citi.banamex.headers.example.service.HeadersService;

@Service
public class HeadersServiceImpl implements HeadersService {

  @Override
  public Map<String, List<String>> getAllHeaders(HttpServletRequest request) {
    return Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(
        Function.identity(), s -> Arrays.asList(request.getHeader(s).split(Constants.COMMA))));
  }

  @Override
  public Map<String, List<String>> getAllHeadersFiltered(HttpServletRequest request,
      List<String> headerNames) {
    return Collections.list(request.getHeaderNames()).stream()
        .filter(f -> headerNames.stream().anyMatch(f::equals))
        .collect(Collectors.toMap(Function.identity(),
            s -> Arrays.asList(request.getHeader(s).split(Constants.COMMA))));
  }

}
