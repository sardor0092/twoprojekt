package Login.login.demo.repository;

import Login.login.demo.entity.TopBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopBooksRepository extends JpaRepository<TopBooks,Long> {

    Page<TopBooks> findAllByNameContainsIgnoreCaseOrId(String key , Long n, Pageable pageable);


}