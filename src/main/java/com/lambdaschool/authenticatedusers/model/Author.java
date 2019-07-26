package com.lambdaschool.authenticatedusers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;
    private String firstname;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();


}
