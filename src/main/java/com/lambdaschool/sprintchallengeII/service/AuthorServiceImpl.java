package com.lambdaschool.sprintchallengeII.service;

import com.lambdaschool.sprintchallengeII.model.Author;
import com.lambdaschool.sprintchallengeII.model.Book;
import com.lambdaschool.sprintchallengeII.model.Wrote;
import com.lambdaschool.sprintchallengeII.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author findById(long authorid) throws EntityNotFoundException {
        return authorRepository.findById(authorid).orElseThrow(() -> new EntityNotFoundException(Long.toString(authorid)));
    }

    @Override
    public List<Author> findAll(Pageable pageable) {
        List<Author> list = new ArrayList<>();
        authorRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Author save(Author author, long id) {
        Author currentAuthor = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if(author.getBooksWrote().size() > 0)
        {
            for(Wrote wrote : author.getBooksWrote())
            {
                currentAuthor.getBooksWrote().add(new Wrote(currentAuthor, wrote.getBook()));
            }
            return authorRepository.save(currentAuthor);
        }
        throw new EntityNotFoundException(author.getFirstname());
    }
}
