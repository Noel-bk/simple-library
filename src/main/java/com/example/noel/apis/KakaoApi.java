package com.example.noel.apis;

import com.example.noel.dto.BookDto;
import com.example.noel.entity.Book;
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

    public Book getBook(String isbn) {

        UriComponents uriComponents = createUriComponents(isbn);
        HttpEntity<?> entity = new HttpEntity<>(createHeaders());

        ResponseEntity<BookDto> response = restTemplate.exchange(
            uriComponents.encode().toUri(),
            HttpMethod.GET,
            entity,
            BookDto.class);
        log.debug("response = {}", response);
        BookDto bookDto = response.getBody();
        log.debug("bookDto = {}", bookDto);

        // TODO
        return bookDto.getDocuments().get(0);

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