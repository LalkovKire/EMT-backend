package finki.ukim.mk.emtlab1.service.impl;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Book;
import finki.ukim.mk.emtlab1.model.Country;
import finki.ukim.mk.emtlab1.model.dto.BookDto;
import finki.ukim.mk.emtlab1.model.enumerations.Category;
import finki.ukim.mk.emtlab1.model.exceptions.AuthorNotFoundException;
import finki.ukim.mk.emtlab1.model.exceptions.BookNotFoundException;
import finki.ukim.mk.emtlab1.model.exceptions.CountryNotFoundException;
import finki.ukim.mk.emtlab1.repository.AuthorRepository;
import finki.ukim.mk.emtlab1.repository.BookRepository;
import finki.ukim.mk.emtlab1.repository.CountryRepository;
import finki.ukim.mk.emtlab1.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorRepository authorRepository,BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getCategory(),bookDto.getName(),author, bookDto.getAvailableCopies());
        this.bookRepository.deleteByNameAndAuthor(bookDto.getName(),author);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long bookId,BookDto bookDto) {
        Book book = this.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public String rentBook(Long bookId) {
        Book book = this.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        if (book.getAvailableCopies() <= 0) {
            return "Not enough copies for rent";
        } else {
            book.setAvailableCopies(book.getAvailableCopies()-1);
            this.bookRepository.save(book);
            return "Successfully rented a book";
        }
    }

    @Override
    public void deleteById(Long id) {
         this.bookRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories() {
         return List.of(Category.values());
    }
}
