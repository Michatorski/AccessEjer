package org.iesfm.jpalibrary.repository;

import org.iesfm.jpalibrary.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book>findByAuthor(String author);

    @Query(nativeQuery = true,
        value = "SELECT DISTINCT b.* FROM book b " +
                "INNER JOIN book_lend bl ON b.isbn = bl.isbn")
    List<Book> findAllLendBooks();
}
