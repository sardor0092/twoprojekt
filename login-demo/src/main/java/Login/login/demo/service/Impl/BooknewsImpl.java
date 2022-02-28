package Login.login.demo.service.Impl;

import Login.login.demo.entity.Booknews;
import Login.login.demo.repository.BooknewsRepository;
import Login.login.demo.service.BooknewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BooknewsImpl implements BooknewsService {

    @Autowired
    BooknewsRepository booknewsRepository;


    @Override
    public Page<Booknews> getAll(Pageable pageable) {
        return booknewsRepository.findAll(pageable);
    }

    @Override
    public Booknews create(Booknews data) {
        return booknewsRepository.save(data);
    }

    @Override
    public Booknews update(Booknews data) {
        return booknewsRepository.save(data);
    }

    @Override
    public void delete(Booknews data) {
        booknewsRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        booknewsRepository.deleteById(id);

    }

    @Override
    public Page<Booknews> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n = Long.parseLong(key);
            int i = Integer.parseInt(key);
            return booknewsRepository.findAllByNameContainsIgnoreCaseOrId(key, n, pageable);

        } catch (Exception e) {
            return booknewsRepository.findAllByNameContainsIgnoreCaseOrId(key, (long) -1, pageable);
        }
    }
}
