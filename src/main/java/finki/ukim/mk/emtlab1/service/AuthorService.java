package finki.ukim.mk.emtlab1.service;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> findByNameOrSurname(String name,String surname);

    Optional<Author> save(String name,String surname,Long countryId);

    void deleteById(Long id);

}
