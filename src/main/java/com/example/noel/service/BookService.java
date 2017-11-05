package com.example.noel.service;

import com.example.noel.entity.Book;
import com.example.noel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findOne(id);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
