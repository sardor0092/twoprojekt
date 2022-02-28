package Login.login.demo.controller;

import Login.login.demo.entity.HistoryBooks;
import Login.login.demo.service.HistoryBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/history")
public class HistoryBooksController {

    @Autowired
    HistoryBooksService historyBooksService;

    @GetMapping
    public Page<HistoryBooks> getAll(@RequestParam (required = false)  String key , Pageable pageable) {
        if (key == null) key= "";
        return historyBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);
    }


    @PostMapping
    public HistoryBooks create(@RequestBody HistoryBooks data) {
        return historyBooksService.create(data);
    }
    @PutMapping
    public HistoryBooks update(@RequestBody HistoryBooks data) {
        return historyBooksService.update(data);
    }
    @DeleteMapping("{id}")
     public void delete(@PathVariable Long id) {
        historyBooksService.deleteById(id);
     }

}
