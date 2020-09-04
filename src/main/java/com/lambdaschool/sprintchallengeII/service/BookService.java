package com.lambdaschool.sprintchallengeII.service;

import com.lambdaschool.sprintchallengeII.model.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findAll(Pageable pageable);

    Book findById(long bookid);

    Book update(Book book, long id);
}
