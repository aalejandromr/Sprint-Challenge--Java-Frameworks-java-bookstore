package com.lambdaschool.sprintchallengeII.repository;

import com.lambdaschool.sprintchallengeII.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
