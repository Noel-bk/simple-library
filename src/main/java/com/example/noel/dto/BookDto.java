package com.example.noel.dto;

import com.example.noel.entity.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BookDto {

    private List<Book> documents;
    private Meta meta;

    @Getter
    @Setter
    @ToString
    static class Meta {
        @JsonProperty(value = "is_end")
        boolean isEnd;
        @JsonProperty(value = "pageable_count")
        Integer pageableCount;
        @JsonProperty(value = "total_count")
        Integer totalCount;
    }

}
