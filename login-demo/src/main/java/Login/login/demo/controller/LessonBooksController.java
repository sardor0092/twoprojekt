package Login.login.demo.controller;

import Login.login.demo.entity.LessonBooks;
import Login.login.demo.service.LessonBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/api/lesson")
public class LessonBooksController {

    @Autowired
    LessonBooksService lessonBooksService;

    @GetMapping
    public Page<LessonBooks> getAll(@RequestParam (required = false)  String key, Pageable pageable){
        if (key == null) key = "";
        return lessonBooksService.findAllByNameContainsIgnoreCaseOrId(key, pageable);

    }

    @PostMapping
    public LessonBooks create(@RequestBody LessonBooks data) {
        return lessonBooksService.create(data);
    }

    @PutMapping
    public LessonBooks update(@RequestBody LessonBooks data) {
        return lessonBooksService.update(data);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        lessonBooksService.deleteById(id);
    }

}
