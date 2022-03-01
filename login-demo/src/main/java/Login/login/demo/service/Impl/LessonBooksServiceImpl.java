package Login.login.demo.service.Impl;

import Login.login.demo.entity.LessonBooks;
import Login.login.demo.repository.LessonBooksRepository;
import Login.login.demo.service.LessonBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LessonBooksServiceImpl implements LessonBooksService {
    @Autowired
    LessonBooksRepository lessonBooksRepository;

    @Override
    public Page<LessonBooks> getAll(Pageable pageable) {
        return lessonBooksRepository.findAll(pageable);
    }

    @Override
    public LessonBooks create(LessonBooks data) {
        return lessonBooksRepository.save(data);
    }

    @Override
    public LessonBooks update(LessonBooks data) {
        return lessonBooksRepository.save(data);
    }

    @Override
    public void delete(LessonBooks data) {

        lessonBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        lessonBooksRepository.deleteById(id);

    }

    @Override
    public Page<LessonBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n = Long.parseLong(key);
            int i = Integer.parseInt(key);
            return lessonBooksRepository.findAllByNameContainsIgnoreCaseOrId(key, n, pageable);
        } catch (Exception e) {
            return lessonBooksRepository.findAllByNameContainsIgnoreCaseOrId(key, (long) -1, pageable);

        }
    }
}
