package org.iesfm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class BookLendId implements Serializable {
    @Column(name = "member_id")
    private int memberId;

    private String isbn;
    @Column(name = "lend_date")
    private Date lendDate;



    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLendId that = (BookLendId) o;
        return memberId == that.memberId && Objects.equals(isbn, that.isbn) && Objects.equals(lendDate, that.lendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, isbn, lendDate);
    }
}
