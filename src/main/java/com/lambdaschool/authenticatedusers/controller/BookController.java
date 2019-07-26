package com.lambdaschool.authenticatedusers.controller;

import com.lambdaschool.authenticatedusers.model.Book;
import com.lambdaschool.authenticatedusers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks()
    {
        List<Book> allBooks = bookService.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
