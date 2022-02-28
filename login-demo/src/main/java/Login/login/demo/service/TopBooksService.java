package Login.login.demo.service;
import Login.login.demo.entity.TopBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopBooksService extends GeneralService <TopBooks, Number>{

    Page<TopBooks> findAllByNameContainsIgnoreCaseOrId(String key , Pageable pageable);
}
