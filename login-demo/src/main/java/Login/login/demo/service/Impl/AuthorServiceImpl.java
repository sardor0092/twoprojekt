package Login.login.demo.service.Impl;

import Login.login.demo.entity.Author;
import Login.login.demo.repository.AuthorRepository;
import Login.login.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public Page<Author> getAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    @Override
    public Author create(Author data) {
        return authorRepository.save(data);
    }

    @Override
    public Author update(Author data) {
        return authorRepository.save(data);
    }

    @Override
    public void delete(Author data) {
        authorRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);

    }

    @Override
    public Page<Author> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n = Long.parseLong(key);
            int i = Integer.parseInt(key);
            return authorRepository.findAllByNameContainsIgnoreCaseOrId(key, n, pageable);
        } catch (Exception e) {
            return authorRepository.findAllByNameContainsIgnoreCaseOrId(key, (long) -1, pageable);
        }
    }
}
