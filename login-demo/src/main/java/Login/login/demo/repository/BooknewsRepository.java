package Login.login.demo.repository;

import Login.login.demo.entity.Booknews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooknewsRepository extends JpaRepository<Booknews,Long> {
    Page<Booknews> findAllByNameContainsIgnoreCaseOrId(String key, Long n, Pageable pageable);
}
