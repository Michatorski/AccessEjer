package org.iesfm.controller;

import org.iesfm.Book;

import org.iesfm.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> findBookByAuthor(
            @RequestParam( value = "author",  required = false) String author){
        if (author==null){
            return bookRepository.findByLentBook();
        }else {
            return bookRepository.findByAuthor(author);
        }
    }

}
