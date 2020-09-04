package com.lambdaschool.sprintchallengeII.service;

import com.lambdaschool.sprintchallengeII.model.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    List<Author> findAll(Pageable pageable);

    Author findById(long authorid);

    Author save(Author author, long id);
}
