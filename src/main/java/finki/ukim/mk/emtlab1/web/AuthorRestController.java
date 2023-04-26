package finki.ukim.mk.emtlab1.web;

import finki.ukim.mk.emtlab1.model.Author;
import finki.ukim.mk.emtlab1.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Author> save(@RequestParam String name, @RequestParam String surname,@PathVariable Long id) {
        return this.authorService.save(name,surname,id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteById(@PathVariable Long id) {
         this.authorService.deleteById(id);
         if (this.authorService.findById(id).isEmpty()) return ResponseEntity.ok().build();
         return ResponseEntity.badRequest().build();
    }
}
