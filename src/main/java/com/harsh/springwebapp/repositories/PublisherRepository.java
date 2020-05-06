package com.harsh.springwebapp.repositories;

import com.harsh.springwebapp.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
