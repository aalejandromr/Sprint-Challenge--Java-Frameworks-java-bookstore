package com.lambdaschool.sprintchallengeII.repository;

import com.lambdaschool.sprintchallengeII.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
