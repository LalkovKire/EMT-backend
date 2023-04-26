package finki.ukim.mk.emtlab1.web;

import finki.ukim.mk.emtlab1.model.Country;
import finki.ukim.mk.emtlab1.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

     private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
         return this.countryService.findById(id)
                 .map(country -> ResponseEntity.ok().body(country))
                 .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam(required = true) String name,@RequestParam String continent) {
        return this.countryService.save(name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Long id) {
        this.countryService.deleteById(id);
        if (this.countryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
