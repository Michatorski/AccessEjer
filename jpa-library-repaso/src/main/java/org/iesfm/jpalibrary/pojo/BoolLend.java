package org.iesfm.jpalibrary.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity

@Table(name = "book_lend")
@IdClass(BookLendId.class)
public class BoolLend {
    @Id
    @Column(name = "member_id")
    private int memberId;
    @Id
    private String isbn;
    @Id
    @JsonFormat(pattern = "yyyy/MM/dd" )
    @Column(name = "lend_date")
    private Date lendDate;
    @OneToOne
    @JoinColumn(name = "isbn",
            referencedColumnName = "isbn",
    insertable = false,
    updatable = false)
    private Book book;

    public BoolLend(int memberId, String isbn, Date lendDate) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.lendDate = lendDate;

    }

    public BoolLend(){

    }

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoolLend boolLend = (BoolLend) o;
        return memberId == boolLend.memberId && Objects.equals(isbn, boolLend.isbn) && Objects.equals(lendDate, boolLend.lendDate) && Objects.equals(book, boolLend.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, isbn, lendDate, book);
    }

    @Override
    public String toString() {
        return "BoolLend{" +
                "memberId=" + memberId +
                ", isbn='" + isbn + '\'' +
                ", lendDate=" + lendDate +
                ", book=" + book +
                '}';
    }
}
