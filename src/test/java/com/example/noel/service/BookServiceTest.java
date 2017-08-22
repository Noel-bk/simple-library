package com.example.noel.service;

import com.example.noel.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    private Book book;

    @Before
    public void foo() {
        book = new Book(null, "978-0804139021", "The Martian", "Andy Weir", "");
    }

    @Test
    public void save() throws Exception {
        Book entity = bookService.save(book);
        assertEquals(book, entity);
    }

}