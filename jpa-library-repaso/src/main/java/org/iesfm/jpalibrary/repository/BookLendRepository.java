package org.iesfm.jpalibrary.repository;

import org.iesfm.jpalibrary.pojo.BookLendId;
import org.iesfm.jpalibrary.pojo.BoolLend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLendRepository extends JpaRepository<BoolLend, BookLendId> {
    @Query(nativeQuery = true,
    value = "SELECT bl.* FROM book_lend bl " +
            "INNER JOIN member m ON bl.member_id = m.id WHERE m.nif=:nif")
    List<BoolLend> findMemeberLends(@Param("nif") String nif);
}
