package Login.login.demo.repository;

import Login.login.demo.entity.FantasticBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FantasticBooksRepository extends JpaRepository<FantasticBooks ,Long> {

    Page<FantasticBooks> findAllByNameContainsIgnoreCaseOrId(String key , Long n, Pageable pageable);


}
