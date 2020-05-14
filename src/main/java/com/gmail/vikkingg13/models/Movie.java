package com.gmail.vikkingg13.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Movie {

    @Id
    private String id;
    private String title;
    private String genre;
    private String producer;
    private double rating;
}
