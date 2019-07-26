package com.lambdaschool.authenticatedusers.service;

import com.lambdaschool.authenticatedusers.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
