package com.lambdaschool.sprintchallengeII.repository;

import com.lambdaschool.sprintchallengeII.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
