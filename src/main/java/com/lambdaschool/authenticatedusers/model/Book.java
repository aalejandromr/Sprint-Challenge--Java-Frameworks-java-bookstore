package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String booktitle;

    private String isbn;
    private long copy;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();




}
