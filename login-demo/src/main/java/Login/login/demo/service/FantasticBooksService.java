package Login.login.demo.service;

import Login.login.demo.entity.FantasticBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FantasticBooksService extends GeneralService<FantasticBooks ,Number> {
    Page<FantasticBooks> findAllByNameContainsIgnoreCaseOrId(String key , Pageable pageable);
}
