package com.lambdaschool.sprintchallengeII.controller;

import com.lambdaschool.sprintchallengeII.model.Book;
import com.lambdaschool.sprintchallengeII.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @ApiOperation(value = "Returns all books with paging ability", responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrive (0..N)"), @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."), @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(asc|desc).")})
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(@PageableDefault(page = 0, size = 1)Pageable pageable)
    {
        List<Book> allBooks = bookService.findAll(pageable);
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
