package org.iesfm.controller;

import org.iesfm.BookLend;
import org.iesfm.repository.BookLendRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class BookLendController {

    private BookLendRepository bookLendRepository;

    public BookLendController(BookLendRepository bookLendRepository) {
        this.bookLendRepository = bookLendRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "members/{nif}/booklends")
    public List<BookLend> findLentByNif(
            @PathVariable(value = "nif", required = false) String nif
    ) {
        return bookLendRepository.findLentByMember(nif);
    }
}
