package br.com.pelissaro.librarySystem.Domain;

public class Loan {
    private Book book;
    private User user;
    private int loanID;


    public Loan(Book book, User user, int loanID) {
        this.book = book;
        this.user = user;
        this.loanID = loanID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", user=" + user +
                ", loanID=" + loanID +
                '}';
    }
}
