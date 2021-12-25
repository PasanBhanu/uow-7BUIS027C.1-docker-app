package com.uowcca.groupt.controller;

import com.uowcca.groupt.rest.BaseResponse;
import com.uowcca.groupt.rest.reqest.CreateBookRequest;
import com.uowcca.groupt.rest.response.GetAllBooksResponse;
import com.uowcca.groupt.rest.response.GetBookResponse;
import com.uowcca.groupt.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public ResponseEntity<GetAllBooksResponse> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @RequestMapping( method = RequestMethod.POST, path = "/", produces = "application/json")
    public ResponseEntity<BaseResponse> createBook(@RequestBody CreateBookRequest payload) {
        return ResponseEntity.ok(booksService.createBook(payload));
    }

    @RequestMapping( method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public ResponseEntity<GetBookResponse> getBook(@PathVariable String id) {
        return ResponseEntity.ok(booksService.getBook(id));
    }

    @RequestMapping( method = RequestMethod.PUT, path = "/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> updateBook(@PathVariable String id, @RequestBody CreateBookRequest payload) {
        return ResponseEntity.ok(booksService.updateBook(id, payload));
    }

    @RequestMapping( method = RequestMethod.DELETE, path = "/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> deleteBook(@PathVariable String id) {
        return ResponseEntity.ok(booksService.deleteBook(id));
    }
}
