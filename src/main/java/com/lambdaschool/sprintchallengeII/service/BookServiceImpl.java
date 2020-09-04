package com.lambdaschool.sprintchallengeII.service;

import com.lambdaschool.sprintchallengeII.exceptions.ResourceNotFoundException;
import com.lambdaschool.sprintchallengeII.model.Book;
import com.lambdaschool.sprintchallengeII.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book findById(long bookid) throws ResourceNotFoundException {
        return bookRepository.findById(bookid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(bookid)));
    }

    @Override
    public List<Book> findAll(Pageable pageable) {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book update(Book book, long id) throws ResourceNotFoundException {
        Book currentBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if (book.getIsbn() != null)
        {
            currentBook.setIsbn(book.getIsbn());
        }
        if(book.getBooktitle() != null)
        {
            currentBook.setBooktitle(book.getBooktitle());
        }
        currentBook.setCopy(book.getCopy());

        return bookRepository.save(currentBook);
    }
}
