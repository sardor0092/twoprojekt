package Login.login.demo.service;

import Login.login.demo.entity.WorldBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorldBooksService extends GeneralService<WorldBooks ,Number> {
    Page<WorldBooks> findAllByNameContainsIgnoreCaseOrId(String key , Pageable pageable);

}
