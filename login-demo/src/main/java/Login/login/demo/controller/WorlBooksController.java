package Login.login.demo.controller;

import Login.login.demo.entity.WorldBooks;
import Login.login.demo.service.WorldBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/world")
public class WorlBooksController {

    @Autowired
    WorldBooksService worldBooksService;

    @GetMapping
    public Page<WorldBooks> getAll(@RequestParam(required = false) String key, Pageable pageable) {
        if (key == null) key ="";
        return worldBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);
    }
    @PostMapping
    public WorldBooks create(@RequestBody WorldBooks data){
        return worldBooksService.create(data);
    }
    @PutMapping
    public WorldBooks update(@RequestBody WorldBooks data){
        return worldBooksService.update(data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        worldBooksService.deleteById(id);
    }

}
