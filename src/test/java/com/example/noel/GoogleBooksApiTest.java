package com.example.noel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class GoogleBooksApiTest {

    private final String THE_MARTIAN_ISBN = "9780804139021";

    @Test
    public void constructUriWithQueryParameter() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
            .scheme("https").host("www.googleapis.com/books/v1/volumes")
            .query("q=isbn:{isbn}").buildAndExpand(THE_MARTIAN_ISBN);

        assertEquals("https://www.googleapis.com/books/v1/volumes?q=isbn:9780804139021", uriComponents.toUriString());
    }

    @Test
    public void testGoogleBooksApi() {
        RestTemplate restTemplate = new RestTemplate();

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
            .scheme("https").host("www.googleapis.com/books/v1/volumes")
            .query("q=isbn:{isbn}").buildAndExpand(THE_MARTIAN_ISBN);

        Object obj = restTemplate.getForObject(uriComponents.toUriString(), Object.class);
        log.debug("obj = {}", obj);
        assertNotNull("NO RESULTS FOUND", obj);
    }

}
