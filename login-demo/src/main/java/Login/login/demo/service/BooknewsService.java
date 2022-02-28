package Login.login.demo.service;

import Login.login.demo.entity.Booknews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BooknewsService extends GeneralService<Booknews,Number> {
    Page<Booknews> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable);
}
