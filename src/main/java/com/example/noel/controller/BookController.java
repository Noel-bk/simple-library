package com.example.noel.controller;

import com.example.noel.apis.KakaoApi;
import com.example.noel.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private KakaoApi kakaoApi;

    @GetMapping(value = "/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return kakaoApi.getBook(isbn);
    }

}
