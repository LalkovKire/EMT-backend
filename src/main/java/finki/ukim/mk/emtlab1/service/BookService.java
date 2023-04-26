package finki.ukim.mk.emtlab1.service;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Book;
import finki.ukim.mk.emtlab1.model.Country;
import finki.ukim.mk.emtlab1.model.dto.BookDto;
import finki.ukim.mk.emtlab1.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long bookId,BookDto bookDto);

    String rentBook(Long id);

    void deleteById(Long id);

    List<Category> findAllCategories();
}
