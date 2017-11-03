package com.example.noel.apis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class KakaoApi {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kakao.rest.app.key}")
    private String REST_APP_KEY;

    private static final String API_HOST = "dapi.kakao.com";
    private static final String BOOK_SEARCH_PATH = "/v2/search/book";

    // TODO Object -> Book
    public Object getBook(String isbn) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(API_HOST)
            .path(BOOK_SEARCH_PATH)
            .queryParam("query", isbn)
            .queryParam("target", "isbn")
            .build();

        HttpEntity<Object> entity = new HttpEntity<>(null, this.createHeaders());

        ResponseEntity<Object> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity, Object.class);

        return response.getBody();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + REST_APP_KEY);
        return headers;
    }

}