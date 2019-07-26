package com.lambdaschool.authenticatedusers.repository;

import com.lambdaschool.authenticatedusers.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
