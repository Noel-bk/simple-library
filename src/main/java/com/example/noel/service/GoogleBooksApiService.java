package com.example.noel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class GoogleBooksApiService {

    private RestTemplate restTemplate;

    // TODO Object -> Book
    public Object getBook(String isbn) {
        restTemplate = new RestTemplate();
        Object obj = restTemplate.getForObject(constructUriWithQueryParameter(isbn), Object.class);
        return obj;
    }

    public URI constructUriWithQueryParameter(String isbn) {
        return UriComponentsBuilder.newInstance()
            .scheme("https").host("www.googleapis.com/books/v1/volumes")
            .query("q=isbn:{isbn}").buildAndExpand(isbn).toUri();
    }

}
