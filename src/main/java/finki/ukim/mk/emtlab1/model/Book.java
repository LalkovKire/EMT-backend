package finki.ukim.mk.emtlab1.model;

import finki.ukim.mk.emtlab1.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private Integer availableCopies;

    public Book() {};

    public Book(Category category, String name, Author author, Integer availableCopies) {
        this.category = category;
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
