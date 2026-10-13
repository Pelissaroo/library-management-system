package br.com.pelissaro.librarySystem.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
@Entity
public class Book {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    public record NewQuantity(int quantity) {}

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    public Book(String title, String author, int quantity_available) {
        this.title = title;
        this.author = author;
        this.quantityAvailable = quantity_available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", quantity_available=" + quantityAvailable +
                '}';
    }

    public boolean isAvailable() {
        return quantityAvailable >= 1;
    }
}
