package finki.ukim.mk.emtlab1.service;

import finki.ukim.mk.emtlab1.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    Optional<Country> save(String name,String continent);

    void deleteByName(String name);

    void deleteById(Long id);
}
