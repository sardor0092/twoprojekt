package Login.login.demo.service;

import Login.login.demo.entity.CalibirBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CalibiBooksService extends GeneralService<CalibirBooks ,Number> {
    Page<CalibirBooks> findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId(String key , Pageable pageable);

}
