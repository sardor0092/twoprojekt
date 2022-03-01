package Login.login.demo.repository;

import Login.login.demo.entity.LessonBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonBooksRepository extends JpaRepository<LessonBooks ,Long> {
    Page<LessonBooks> findAllByNameContainsIgnoreCaseOrId(String key, Long n , Pageable pageable);
}
