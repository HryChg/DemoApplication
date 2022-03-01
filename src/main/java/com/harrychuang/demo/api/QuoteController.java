package com.harrychuang.demo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrychuang.demo.model.Quote;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("api/v1/quote")
@RestController
public class QuoteController {

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  @Autowired
  public QuoteController(RestTemplate restTemplate, ObjectMapper objectMapper) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  // TODO-HC Handle JsonProcessingException Here
  @GetMapping
  public String getQuoteOfDay() throws JsonProcessingException {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(headers);
    String res =
        restTemplate
            .exchange("https://quotes.rest/qod?language=en", HttpMethod.GET, entity, String.class)
            .getBody();
    Quote quote = objectMapper.readValue(res, Quote.class);
    return quote.toString();
  }

  // TODO-HC Handle JsonProcessingException Here
  @GetMapping(path = "/alt")
  public String getQuoteOfDayAlt() throws IOException {
    String filePath = "src/main/resources/mockedResponse/quote-of-day.json";
    String res = new String(Files.readAllBytes(Paths.get(filePath)));
    Quote quote = objectMapper.readValue(res, Quote.class);
    return quote.toString();
  }
}
