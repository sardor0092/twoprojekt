package Login.login.demo.repository;

import Login.login.demo.entity.BaddiyBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadiiyBooksRepository extends JpaRepository<BaddiyBooks , Long> {
    Page<BaddiyBooks> findAllByNameContainsIgnoreCaseOrId(String key,Long n, Pageable pageable);

}
