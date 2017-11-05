package com.example.noel.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection(targetClass = String.class)
    private List<String> authors;
    private String title;
    // TODO
    // ISBN 번호. 국제 표준 도서번호(ISBN10,ISBN13) (ISBN10,ISBN13 중에 하나 이상 존재하면 ' '(공백)을 구분자로 출렴됨)
    // https://developers.kakao.com/docs/restapi/search#책-검색
    private String isbn;
    private String thumbnail;
    private String url;
    @JsonProperty(value = "contents")
    private String description;
    private String category;

}
