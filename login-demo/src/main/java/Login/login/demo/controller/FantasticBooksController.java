package Login.login.demo.controller;

import Login.login.demo.entity.FantasticBooks;
import Login.login.demo.service.FantasticBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/fantastic")
public class FantasticBooksController {

    @Autowired
    FantasticBooksService fantasticBooksService;

    @GetMapping
    public Page<FantasticBooks> getAll(@RequestParam (required = false)  String key, Pageable pageable) {
        if (key ==null) key ="";
        return fantasticBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);
    }

    @PostMapping
    public FantasticBooks create (@RequestBody FantasticBooks data) {
        return fantasticBooksService.create(data);
    }
    @PutMapping
    public FantasticBooks update(@RequestBody FantasticBooks data) {
        return fantasticBooksService.update(data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        fantasticBooksService.deleteById(id);
    }
}
