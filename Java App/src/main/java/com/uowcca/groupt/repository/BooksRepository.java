package com.uowcca.groupt.repository;

import com.uowcca.groupt.dao.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<Book, String> {
}
