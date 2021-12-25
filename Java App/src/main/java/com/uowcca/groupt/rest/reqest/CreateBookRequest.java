package com.uowcca.groupt.rest.reqest;

import lombok.Data;

@Data
public class CreateBookRequest {
    private String name;
    private String author;
    private String isbn;
    private String publishedAt;
    private String description;
}
