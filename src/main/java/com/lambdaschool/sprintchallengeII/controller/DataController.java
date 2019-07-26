package com.lambdaschool.sprintchallengeII.controller;

import com.lambdaschool.sprintchallengeII.model.Author;
import com.lambdaschool.sprintchallengeII.model.Book;
import com.lambdaschool.sprintchallengeII.model.Wrote;
import com.lambdaschool.sprintchallengeII.service.AuthorService;
import com.lambdaschool.sprintchallengeII.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private AuthorService authorService;
    private BookService bookService;

    @ApiOperation(value = "assigns a book already in the system (bookid) to an author already in the system (authorid) (see how roles are handled for users)", response = void.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Book Assigned", response = void.class),
            //            @ApiResponse(code = 500, message = "There was an error creating the restaurant", response = ErrorDetail.class)
    })
    @PostMapping(value = "/books/{bookid}/authors/{authorid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addAuthorToBook(@PathVariable long bookid, @PathVariable long authorid) throws URISyntaxException {
        Author author = authorService.findById(authorid);
        author.getBooksWrote().add(new Wrote(author, bookService.findById(bookid)));
        authorService.save(author, authorid);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


    @PutMapping(value = "/books/{bookid}")
    public ResponseEntity<?> updateRestaurant(@RequestBody Book updateBook, @PathVariable long bookid) {
        bookService.update(updateBook, bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long restaurantid) {
        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
