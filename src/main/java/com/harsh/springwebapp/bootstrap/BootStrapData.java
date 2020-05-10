package com.harsh.springwebapp.bootstrap;

import com.harsh.springwebapp.entities.Author;
import com.harsh.springwebapp.entities.Book;
import com.harsh.springwebapp.entities.Publisher;
import com.harsh.springwebapp.repositories.AuthorRepository;
import com.harsh.springwebapp.repositories.BookRepository;
import com.harsh.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pearsonEducation = new Publisher("Pearson Education", "7th Floor, Knowledge Boulevard, A-8",
                "Noida", "UP", 201309);
        publisherRepository.save(pearsonEducation);

        Publisher sChandEducation = new Publisher("S Chand", "7th Floor, Knowledge Boulevard, A-8",
                "Noida", "UP", 201340);
        publisherRepository.save(sChandEducation);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "10001");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pearsonEducation);
        pearsonEducation.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pearsonEducation);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "10002");
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(pearsonEducation);
        sChandEducation.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(sChandEducation);

        Author hcVerma = new Author("HC", "Verma");
        Book physics = new Book("Fundamentals of Physics", "10003");
        hcVerma.getBooks().add(physics);
        physics.getAuthors().add(hcVerma);

        physics.setPublisher(sChandEducation);
        sChandEducation.getBooks().add(physics);

        authorRepository.save(hcVerma);
        bookRepository.save(physics);
        publisherRepository.save(sChandEducation);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Author: " + authorRepository.count());
        System.out.println("Number of Publisher: " + publisherRepository.count());
    }
}
