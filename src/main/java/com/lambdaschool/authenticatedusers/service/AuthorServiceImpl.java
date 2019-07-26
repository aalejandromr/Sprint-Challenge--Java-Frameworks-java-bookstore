package com.lambdaschool.authenticatedusers.service;

import com.lambdaschool.authenticatedusers.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
}
