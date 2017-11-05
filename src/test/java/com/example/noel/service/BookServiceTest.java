package com.example.noel.service;

import com.example.noel.apis.KakaoApi;
import com.example.noel.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BookServiceTest {

    private final String SPRING_IN_ACTION_KO_ISBN = "9791185890388";

    @Autowired
    private KakaoApi kakaoApi;

    @Autowired
    private BookService bookService;

    @Test
    public void save() throws Exception {
        Book book = kakaoApi.getBook(SPRING_IN_ACTION_KO_ISBN);

        Book savedEntity = bookService.save(book);
        log.debug("savedEntity = {}", savedEntity);

        assertEquals(book, savedEntity);
    }

}