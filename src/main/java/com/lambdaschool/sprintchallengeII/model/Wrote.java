package com.lambdaschool.sprintchallengeII.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "wrotes")
public class Wrote extends Auditable implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "booksWrote", "hibernateLazyInitializer" })
    @JoinColumn(name = "authorid")
    private Author author;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "booksWrote", "hibernateLazyInitializer"})
    @JoinColumn(name = "bookid")
    private Book book;

    public Wrote(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public Wrote() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if(!(o instanceof Wrote))
        {
            return false;
        }

        Wrote wrote = (Wrote)o;
        return getAuthor().equals(wrote.getAuthor()) && getBook().equals(wrote.getBook());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getBook(), getAuthor());
    }
}
