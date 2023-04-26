package finki.ukim.mk.emtlab1.service.impl;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.model.Country;
import finki.ukim.mk.emtlab1.model.exceptions.CountryNotFoundException;
import finki.ukim.mk.emtlab1.repository.AuthorRepository;
import finki.ukim.mk.emtlab1.service.AuthorService;
import finki.ukim.mk.emtlab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final CountryService countryService;
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(CountryService countryService, AuthorRepository authorRepository) {
        this.countryService = countryService;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByNameOrSurname(String name,String surname) {
        if (name.isEmpty() && surname.isEmpty())
            throw new IllegalArgumentException();
        return this.authorRepository.findByNameOrSurname(name,surname);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryService.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
        if (name.isEmpty() || surname.isEmpty() || countryId==null)
            throw new IllegalArgumentException();
        if (this.findByNameOrSurname(name, surname).isEmpty()){
            Author author = new Author(name,surname,country);
            this.authorRepository.save(author);
            return Optional.of(author);
        } else {
            this.authorRepository.deleteByNameAndSurname(name,surname);
            Author author = new Author(name,surname,country);
            this.authorRepository.save(author);
            return Optional.of(author);
        }
    }

    @Override
    public void deleteById(Long id) {
         this.authorRepository.deleteById(id);
    }
}
