package finki.ukim.mk.emtlab1.model.dto;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Book;
import finki.ukim.mk.emtlab1.model.enumerations.Category;
import lombok.Data;

@Data
public class BookDto {

    private Category category;

    private String name;

    private Long authorId;

    private Integer availableCopies;

    public BookDto(){}

    public BookDto(Category category, String name, Long author, Integer availableCopies) {
        this.category = category;
        this.name = name;
        this.authorId = author;
        this.availableCopies = availableCopies;
    }
}
