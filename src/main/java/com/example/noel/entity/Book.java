package com.example.noel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String description;

}
