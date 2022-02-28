package Login.login.demo.service;

import Login.login.demo.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService extends GeneralService<Author, Number> {
    Page<Author> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable);

}
