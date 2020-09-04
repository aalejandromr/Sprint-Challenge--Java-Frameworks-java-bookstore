package com.lambdaschool.sprintchallengeII.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktitle;

    private String isbn;
    private long copy;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Wrote> booksWrote = new ArrayList<>();

    public List<Wrote> getBooksWrote() {
        return booksWrote;
    }

    public void setBooksWrote(List<Wrote> booksWrote) {
        this.booksWrote = booksWrote;
    }

    public Book() {
    }

    public Book(String booktitle, String isbn, long copy) {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public long getId() {
        return bookid;
    }

    public void setId(long id) {
        this.bookid = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getCopy() {
        return copy;
    }

    public void setCopy(long copy) {
        this.copy = copy;
    }

}
