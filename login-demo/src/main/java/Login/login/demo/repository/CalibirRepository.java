package Login.login.demo.repository;

import Login.login.demo.entity.CalibirBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalibirRepository extends JpaRepository<CalibirBooks ,Long> {
    Page<CalibirBooks> findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId(String key , String key1, Long id, Pageable pageable);
}
