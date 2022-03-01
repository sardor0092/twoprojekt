package Login.login.demo.service;

import Login.login.demo.entity.LessonBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LessonBooksService extends GeneralService<LessonBooks ,Number>  {
    Page<LessonBooks> findAllByNameContainsIgnoreCaseOrId(String key,Pageable pageable);

}
