package com.uowcca.groupt.service;

import com.uowcca.groupt.dao.Book;
import com.uowcca.groupt.repository.BooksRepository;
import com.uowcca.groupt.rest.BaseResponse;
import com.uowcca.groupt.rest.reqest.CreateBookRequest;
import com.uowcca.groupt.rest.response.GetAllBooksResponse;
import com.uowcca.groupt.rest.response.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public GetAllBooksResponse getAllBooks() {
        List<Book> books = booksRepository.findAll();
        GetAllBooksResponse response = new GetAllBooksResponse();
        response.setData(books);
        response.setStatus(200);
        response.setMessage("Books data retrieved");
        return response;
    }

    public GetBookResponse getBook(String id) {
        Optional<Book> book = booksRepository.findById(id);
        GetBookResponse response = new GetBookResponse();
        if (book.isPresent()) {
            response.setData(book.get());
            response.setStatus(200);
            response.setMessage("Book data retrieved");
        }else{
            response.setStatus(404);
            response.setMessage("No book found");
        }
        return response;
    }

    public BaseResponse createBook(CreateBookRequest payload) {
        Book book = new Book();
        book.setName(payload.getName());
        book.setAuthor(payload.getAuthor());
        book.setDescription(payload.getDescription());
        book.setIsbn(payload.getIsbn());
        book.setPublishedAt(payload.getPublishedAt());
        booksRepository.save(book);
        BaseResponse response = new BaseResponse();
        response.setStatus(200);
        response.setMessage("Book created successfully");
        return response;
    }

    public BaseResponse updateBook(String id, CreateBookRequest payload) {
        Optional<Book> book = booksRepository.findById(id);
        BaseResponse response = new BaseResponse();
        if (book.isPresent()) {
            if (payload.getName() != null) {book.get().setName(payload.getName());}
            if (payload.getAuthor() != null) {book.get().setAuthor(payload.getAuthor());}
            if (payload.getDescription() != null) {book.get().setDescription(payload.getDescription());}
            if (payload.getIsbn() != null) {book.get().setIsbn(payload.getIsbn());}
            if (payload.getPublishedAt() != null) {book.get().setPublishedAt(payload.getPublishedAt());}
            booksRepository.save(book.get());
            response.setStatus(200);
            response.setMessage("Book updated successfully");
        }else{
            response.setStatus(404);
            response.setMessage("No book found");
        }
        return response;
    }

    public BaseResponse deleteBook(String id) {
        Optional<Book> book = booksRepository.findById(id);
        BaseResponse response = new BaseResponse();
        if (book.isPresent()) {
            booksRepository.delete(book.get());
            response.setStatus(200);
            response.setMessage("Book delete successfully");
        }else{
            response.setStatus(404);
            response.setMessage("No book found");
        }
        return response;
    }
}
