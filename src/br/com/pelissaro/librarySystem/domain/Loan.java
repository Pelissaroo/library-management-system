package br.com.pelissaro.librarySystem.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Loan {
    private Book book;
    private User user;
    private int loanID;
    private LocalDateTime created_at;
    private LocalDateTime returned_at;


    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    @Override
    public String toString() {
        return "Loan{" +
                book +
                ", " + user +
                ", loanID=" + loanID +
                ", created_at=" + created_at +
                ", returned_at=" + returned_at +
                '}';
    }

    public int getLoanID() {
        return loanID;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getReturned_at() {
        return returned_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setReturned_at(LocalDateTime returned_at) {
        this.returned_at = returned_at;
    }
}
