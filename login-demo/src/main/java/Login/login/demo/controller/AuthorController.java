package Login.login.demo.controller;

import Login.login.demo.entity.Author;
import Login.login.demo.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "*" ,maxAge = 3600)
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public Page<Author> getAll (@RequestParam (required = false) String key , Pageable pageable) {
        if (key == null)  key ="";
        return authorService.findAllByNameContainsIgnoreCaseOrId(key, pageable);

    }
    @PostMapping
    public Author create (@RequestBody Author data) {
        return authorService.create(data);
    }

    @PutMapping
    public Author update(@RequestBody Author data) {
        return authorService.update(data);
    }

     @DeleteMapping("{id}")
    public void delete (@PathVariable Long id) {
         authorService.deleteById(id);
     }


}
