package com.example.noel.service;

import com.example.noel.apis.KakaoApi;
import com.example.noel.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BookServiceTest {

    private final String SPRING_IN_ACTION_KO_ISBN = "9791185890388";

    private static boolean initialized = false;

    @Autowired
    private KakaoApi kakaoApi;

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() {
        if (!initialized) {
            bookService.save(kakaoApi.getBook(SPRING_IN_ACTION_KO_ISBN));
            log.info("setUp()...");
            initialized = true;
        }
    }

    @Test
    @Transactional
    public void findAll() {
        List<Book> books = bookService.findAll();
        assertTrue("Book list is empty!!", !books.isEmpty());
    }

    @Test
    public void save() throws Exception {
        Book book = kakaoApi.getBook(SPRING_IN_ACTION_KO_ISBN);

        Book savedEntity = bookService.save(book);
        log.debug("savedEntity = {}", savedEntity);

        assertEquals(book, savedEntity);
    }

}