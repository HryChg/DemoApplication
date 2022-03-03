package com.harrychuang.demo.api;

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

@RequestMapping("api/v1/example")
@RestController
public class ExampleOrgController {

  private final RestTemplate restTemplate;

  @Autowired
  public ExampleOrgController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping
  public String getQuoteOfDay() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>(headers);
    String res =
        restTemplate
            .exchange("https://example.com/", HttpMethod.GET, entity, String.class)
            .getBody();
    return res;
  }
}
