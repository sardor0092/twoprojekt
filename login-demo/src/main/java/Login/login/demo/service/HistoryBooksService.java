package Login.login.demo.service;

import Login.login.demo.entity.HistoryBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryBooksService extends GeneralService<HistoryBooks,Number> {
    Page<HistoryBooks> findAllByNameContainsIgnoreCaseOrId(String key , Pageable pageable);

}
