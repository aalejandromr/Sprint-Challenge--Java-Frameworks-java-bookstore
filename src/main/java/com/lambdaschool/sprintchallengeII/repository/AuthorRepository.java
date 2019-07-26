package com.lambdaschool.sprintchallengeII.repository;

import com.lambdaschool.sprintchallengeII.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
