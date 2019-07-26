package com.lambdaschool.authenticatedusers;

// Vivek Vishwanath

import com.lambdaschool.authenticatedusers.model.*;
import com.lambdaschool.authenticatedusers.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{

    RoleRepository rolerepos;
    UserRepository userrepos;
    QuoteRepository todorepos;
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, QuoteRepository todorepos, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        rolerepos.save(r1);
        rolerepos.save(r2);

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users);
        u1.getQuotes().add(new Quote("Live long and prosper", u1));
        u1.getQuotes().add(new Quote("The enemy of my enemy is the enemy I kill last", u1));
        u1.getQuotes().add(new Quote("Beam me up", u1));
        userrepos.save(u1);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        User u2 = new User("admin", "password", admins);
        u2.getQuotes().add(new Quote("A creative man is motivated by the desire to achieve, not by the desire to beat others", u2));
        u2.getQuotes().add(new Quote("The question isn't who is going to let me; it's who is going to stop me.", u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("Bob", "password", users);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Jane", "password", users);
        userrepos.save(u4);

        Book book1 = new Book("Book Test 1","ASDN213A",2019);
        Book book2 = new Book("Book Test 2","NSIW1922",2019);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Wrote> booksWrote = new ArrayList<>();
        booksWrote = new ArrayList<>();
        booksWrote.add(new Wrote(new Author(), book1));
        Author author1 = new Author("Author lastname", "Author firstname");
        author1.getBooksWrote().add(new Wrote(author1, book1));
        authorRepository.save(author1);

//        Book book1 = new Book("Book 1", "1231dasdaB", 2019);
//        book1.setAuthor(author1);
//        bookRepository.save(book1);
    }
}