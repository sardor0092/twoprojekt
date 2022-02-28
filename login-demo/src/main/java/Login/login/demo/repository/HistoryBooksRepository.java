package Login.login.demo.repository;

import Login.login.demo.entity.HistoryBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface HistoryBooksRepository extends JpaRepository<HistoryBooks ,Long> {
    Page<HistoryBooks> findAllByNameContainsIgnoreCaseOrId(String key , Long n , Pageable pageable);
}
