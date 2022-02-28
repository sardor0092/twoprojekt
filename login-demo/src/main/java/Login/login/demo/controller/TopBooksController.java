package Login.login.demo.controller;
import Login.login.demo.entity.TopBooks;
import Login.login.demo.service.TopBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/topbooks")
public class TopBooksController {

    @Autowired
    TopBooksService topBooksService;



    @GetMapping
    public Page<TopBooks> getAll(@RequestParam (required = false) String key , Pageable pageable) {
        if (key == null) key ="";
        return topBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);
    }
     @PostMapping
    public TopBooks create(@RequestBody TopBooks data) {
      return   topBooksService.create(data);
     }
     @PutMapping
    public TopBooks update(@RequestBody TopBooks data) {
        return topBooksService.update(data);
     }
     @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        topBooksService.deleteById(id);

     }


}
