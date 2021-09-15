package org.iesfm.repository;

import org.iesfm.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, String> {


    List<Book>findByAuthor(String author);

    @Query(value = "SELECT b.* FROM book b " +
            "INNER JOIN book_lend bl ON b.isbn=bl.isbn",
    nativeQuery = true)
    List<Book> findByLentBook();
}
