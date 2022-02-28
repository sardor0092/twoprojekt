package Login.login.demo.controller;

import Login.login.demo.entity.BaddiyBooks;
import Login.login.demo.service.BadiiyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/badiy")
public class BaddiyBooksController {

    @Autowired
    BadiiyBooksService badiiyBooksService;


    @GetMapping
    public Page<BaddiyBooks> getAll(@RequestParam (required = false)  String key , Pageable pageable) {
        if (key == null) key = "";
        return badiiyBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);

    }

    @PostMapping
    public BaddiyBooks create(@RequestBody BaddiyBooks data) {
        return badiiyBooksService.create(data);
    }

    @PutMapping
    public  BaddiyBooks update(@RequestBody BaddiyBooks data) {
        return badiiyBooksService.update(data);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        badiiyBooksService.deleteById(id);
    }

}
