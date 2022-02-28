package Login.login.demo.controller;

import Login.login.demo.entity.Booknews;
import Login.login.demo.service.BooknewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booknews")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BooknewsController {

    @Autowired
    BooknewsService booknewsService;


    @GetMapping
    public Page<Booknews> getAll(@RequestParam(required = false) String key, Pageable pageable) {
        if (key == null) key = "";
        return booknewsService.findAllByNameContainsIgnoreCaseOrId(key, pageable);

    }

    @PostMapping
    public Booknews create(@RequestBody Booknews data) {
        return booknewsService.create(data);
    }

    @PutMapping

    public Booknews update(@RequestBody Booknews data) {
        return booknewsService.update(data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        booknewsService.deleteById(id);
    }


}
