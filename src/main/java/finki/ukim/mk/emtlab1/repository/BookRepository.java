package finki.ukim.mk.emtlab1.repository;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    void deleteByNameAndAuthor(String name, Author author);
}
