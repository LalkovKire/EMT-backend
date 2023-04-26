package finki.ukim.mk.emtlab1.model.config;

import finki.ukim.mk.emtlab1.model.dto.BookDto;
import finki.ukim.mk.emtlab1.model.enumerations.Category;
import finki.ukim.mk.emtlab1.service.AuthorService;
import finki.ukim.mk.emtlab1.service.BookService;
import finki.ukim.mk.emtlab1.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitialize {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;


    public DataInitialize(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void init() {

        this.countryService.save("Germany","Europe");
        this.countryService.save("Greece","Europe");
        this.countryService.save("Hungary","Europe");
        this.countryService.save("Portugal","Europe");
        this.countryService.save("Slovenia","Europe");
        this.countryService.save("France","Europe");
        this.countryService.save("Croatia","Europe");

        this.authorService.save("Narayana","Murthy", 1L);
        this.authorService.save("E.M.","Foster",1L);
        this.authorService.save("Amrita","Pritam",2L);
        this.authorService.save("Vikram","Seth",3L);
        this.authorService.save("Charles","Darwin",4L);
        this.authorService.save("Mohan","Rakesh",5L);
        this.authorService.save("Leo","Tolstoy",7L);
        this.authorService.save("Jules","Verne",6L);

        BookDto bookDto1 = new BookDto(Category.FANTASY,"Alice in Wonderland",1L,5);
        BookDto bookDto2 = new BookDto(Category.DRAMA,"Arms and the Man",2L,1);
        BookDto bookDto3 = new BookDto(Category.THRILLER,"Death of a City",3L,2);
        BookDto bookDto4 = new BookDto(Category.BIOGRAPHY,"Book test - 1",1L,2);
        BookDto bookDto5 = new BookDto(Category.FANTASY,"Book test - 2",2L,5);
        BookDto bookDto6 = new BookDto(Category.NOVEL,"Book test - 3",7L,6);
        BookDto bookDto7 = new BookDto(Category.CLASSICS,"Book test - 4",1L,1);
        BookDto bookDto8 = new BookDto(Category.CLASSICS,"Book test - 5",2L,3);
        BookDto bookDto9 = new BookDto(Category.DRAMA,"Book test - 6",5L,3);
        BookDto bookDto10 = new BookDto(Category.FANTASY,"Book test - 7",2L,4);
        BookDto bookDto11 = new BookDto(Category.BIOGRAPHY,"Book test - 8",4L,5);
        BookDto bookDto12 = new BookDto(Category.NOVEL,"Book test - 9",1L,7);
        BookDto bookDto13 = new BookDto(Category.NOVEL,"Book test - 10",2L,8);
        BookDto bookDto14 = new BookDto(Category.THRILLER,"Book test - 11",6L,9);
        BookDto bookDto15 = new BookDto(Category.DRAMA,"Book test - 12",4L,0);
        BookDto bookDto16 = new BookDto(Category.CLASSICS,"Book test - 13",3L,1);
        BookDto bookDto17 = new BookDto(Category.HISTORY,"Book test - 14",6L,4);
        BookDto bookDto18 = new BookDto(Category.FANTASY,"Book test - 15",7L,7);
        BookDto bookDto19 = new BookDto(Category.HISTORY,"Book test - 16",5L,5);
        BookDto bookDto20 = new BookDto(Category.THRILLER,"Book test - 17",5L,3);
        BookDto bookDto21 = new BookDto(Category.HISTORY,"Book test - 18",3L,1);
        BookDto bookDto22 = new BookDto(Category.THRILLER,"Book test - 19",1L,2);
        BookDto bookDto23 = new BookDto(Category.DRAMA,"Book test - 20",1L,8);
        BookDto bookDto24 = new BookDto(Category.BIOGRAPHY,"Book test - 21",2L,5);
        BookDto bookDto26 = new BookDto(Category.CLASSICS,"Book test - 22",3L,1);
        BookDto bookDto27 = new BookDto(Category.DRAMA,"Book test - 23",4L,2);
        BookDto bookDto25 = new BookDto(Category.NOVEL,"Book test - 24",6L,0);


        this.bookService.save(bookDto1);
        this.bookService.save(bookDto2);
        this.bookService.save(bookDto3);
        this.bookService.save(bookDto4);
        this.bookService.save(bookDto5);
        this.bookService.save(bookDto6);
        this.bookService.save(bookDto7);
        this.bookService.save(bookDto8);
        this.bookService.save(bookDto9);
        this.bookService.save(bookDto10);
        this.bookService.save(bookDto11);
        this.bookService.save(bookDto12);
        this.bookService.save(bookDto13);
        this.bookService.save(bookDto14);
        this.bookService.save(bookDto15);
        this.bookService.save(bookDto16);
        this.bookService.save(bookDto17);
        this.bookService.save(bookDto18);
        this.bookService.save(bookDto19);
        this.bookService.save(bookDto20);
        this.bookService.save(bookDto21);
        this.bookService.save(bookDto22);
        this.bookService.save(bookDto23);
        this.bookService.save(bookDto24);
        this.bookService.save(bookDto25);
        this.bookService.save(bookDto26);
        this.bookService.save(bookDto27);


    }
}
