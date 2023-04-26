package finki.ukim.mk.emtlab1.service.impl;

import finki.ukim.mk.emtlab1.model.Country;
import finki.ukim.mk.emtlab1.repository.CountryRepository;
import finki.ukim.mk.emtlab1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findByName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException();
        return this.countryRepository.findByName(name);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        if (name.isEmpty() || continent.isEmpty())
            throw new IllegalArgumentException();
        this.countryRepository.deleteByName(name);
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteByName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException();
        this.countryRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
