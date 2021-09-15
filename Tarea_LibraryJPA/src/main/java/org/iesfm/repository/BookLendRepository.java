package org.iesfm.repository;

import org.iesfm.BookLend;
import org.iesfm.BookLendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLendRepository extends JpaRepository <BookLend, BookLendId> {

    @Query(value = "SELECT bl.* FROM book_lend bl " +
            "INNER JOIN member m ON bl.member_id=m.id " +
            "WHERE m.nif=:nif",
    nativeQuery = true)
    List<BookLend> findLentByMember (String nif);
}
