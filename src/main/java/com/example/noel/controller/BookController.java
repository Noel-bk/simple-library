package com.example.noel.controller;

import com.example.noel.service.GoogleBooksApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private GoogleBooksApiService googleBooksApiService;

    @GetMapping(value = "/{isbn}")
    public Object getBook(@PathVariable String isbn) {
        return googleBooksApiService.getBook(isbn);
    }
}
