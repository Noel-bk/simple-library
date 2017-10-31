package com.example.noel.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GoogleBooksApiServiceTest {

    private static final String THE_MARTIAN_ISBN = "9780804139021";

    @Autowired
    private GoogleBooksApiService googleBooksApiService;

    @Test
    public void getBookInfo() throws Exception {
        Object bookInfo = googleBooksApiService.getBookInfo(THE_MARTIAN_ISBN);
        log.info("{}", bookInfo);
    }
}