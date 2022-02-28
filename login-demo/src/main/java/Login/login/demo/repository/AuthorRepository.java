package Login.login.demo.repository;

import Login.login.demo.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Page<Author> findAllByNameContainsIgnoreCaseOrId(String key, Long n, Pageable pageable);



}
