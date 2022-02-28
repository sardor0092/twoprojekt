package Login.login.demo.service;


import Login.login.demo.entity.BaddiyBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BadiiyBooksService extends GeneralService<BaddiyBooks,Number> {
    Page<BaddiyBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable);

}
