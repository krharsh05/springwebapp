package com.harsh.springwebapp.repositories;

import com.harsh.springwebapp.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
