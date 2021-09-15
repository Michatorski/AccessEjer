package org.iesfm;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(BookLendId.class)
@Table(name = "book_lend")
public class BookLend {
    @Id
    @Column(name = "member_id")
    private int memberId;

    @Id
    @Column(name = "lend_date", nullable = false)
    private Date lendDate;

    @Id
    @Column(nullable = false)
    private String isbn;

    @OneToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @Id
    private Book book;


    public int getMemberId(){
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return memberId == bookLend.memberId && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(isbn, bookLend.isbn) && Objects.equals(book, bookLend.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, lendDate, isbn, book);
    }
}
