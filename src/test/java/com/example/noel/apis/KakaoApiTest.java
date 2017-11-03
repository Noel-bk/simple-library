package com.example.noel.apis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KakaoApiTest {

    private final String SPRING_IN_ACTION_KO_ISBN = "9791185890388";

    @Autowired
    private KakaoApi kakaoApi;

    @Test
    public void getBook() throws Exception {
        Object book = kakaoApi.getBook(SPRING_IN_ACTION_KO_ISBN);
        assertNotNull(book);
    }

}