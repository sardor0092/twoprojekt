package Login.login.demo.controller;

import Login.login.demo.entity.CalibirBooks;
import Login.login.demo.service.CalibiBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/calib")
public class CalibirBooksController {

    @Autowired
    CalibiBooksService calibiBooksService;

    @GetMapping
    public Page<CalibirBooks> getAll(@RequestParam (required = false) String key  ,Pageable pageable  ) {
        if (key == null) key = "";
        return calibiBooksService.findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId(key, pageable);
    }
    @PostMapping
    public CalibirBooks create(@RequestBody CalibirBooks calibirBooks) {
        return calibiBooksService.create(calibirBooks);
    }
    @PutMapping
    public CalibirBooks update(@RequestBody CalibirBooks calibirBooks) {
        return calibiBooksService.update(calibirBooks);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        calibiBooksService.deleteById(id);
    }


}
