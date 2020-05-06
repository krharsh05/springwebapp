package com.harsh.springwebapp.repositories;

import com.harsh.springwebapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
