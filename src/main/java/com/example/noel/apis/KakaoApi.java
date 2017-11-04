package com.example.noel.apis;

import com.example.noel.entity.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.IOException;

@Service
@Slf4j
public class KakaoApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Value("${kakao.rest.app.key}")
    private String REST_APP_KEY;

    private static final String API_HOST = "dapi.kakao.com";
    private static final String BOOK_SEARCH_PATH = "/v2/search/book";

    public Book getBook(String isbn) {

        UriComponents uriComponents = createUriComponents(isbn);
        HttpEntity<?> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<String> response = restTemplate.exchange(
            uriComponents.encode().toUri(),
            HttpMethod.GET,
            entity,
            String.class);

        log.debug("response = {}", response.getBody());

        try {
            JsonNode root = mapper.readTree(response.getBody());
            log.debug("root = {}", root);

            JsonNode documents = root.findPath("documents");
            log.debug("documents = {}", documents);

            Book book = mapper.readValue(documents.get(0).toString(), Book.class);
            log.debug("Book = {}", book);
            return book;

        } catch (IOException e) {
            e.printStackTrace();
            // TODO
        }

        return null;
    }

    private UriComponents createUriComponents(String isbn) {
        return UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(API_HOST)
            .path(BOOK_SEARCH_PATH)
            .queryParam("query", isbn)
            .queryParam("target", "isbn")
            .build();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + REST_APP_KEY);
        return headers;
    }

}