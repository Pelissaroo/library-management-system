package br.com.pelissaro.librarySystem.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "loan")
@Entity
public class Loan {
    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "returned_at")
    private LocalDateTime returnedAt;

    public record LoanRequest(Integer bookId, Integer userId) {}

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Loan{" +
                book +
                ", " + user +
                ", loanID=" + id +
                ", created_at=" + createdAt +
                ", returned_at=" + returnedAt +
                '}';
    }
}
