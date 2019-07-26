package com.lambdaschool.authenticatedusers.repository;

import com.lambdaschool.authenticatedusers.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
