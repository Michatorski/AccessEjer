package org.iesfm.jpalibrary.pojo;


import java.io.Serializable;
import java.util.Date;

public class BookLendId implements Serializable {
    private int memberId;
    private String isbn;
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
}
