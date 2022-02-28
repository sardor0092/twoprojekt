package Login.login.demo.repository;

import Login.login.demo.entity.WorldBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldBooksRepository extends JpaRepository<WorldBooks,Long> {
    Page<WorldBooks> findAllByNameContainsIgnoreCaseOrId(String key , Long n, Pageable pageable);
}
