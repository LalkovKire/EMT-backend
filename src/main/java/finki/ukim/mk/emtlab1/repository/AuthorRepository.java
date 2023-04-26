package finki.ukim.mk.emtlab1.repository;

import finki.ukim.mk.emtlab1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByNameOrSurname(String name,String surname);

    void deleteByNameAndSurname(String name,String surname);
}
