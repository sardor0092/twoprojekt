package Login.login.demo.service.Impl;

import Login.login.demo.entity.TopBooks;
import Login.login.demo.repository.TopBooksRepository;
import Login.login.demo.service.TopBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopBooksServiceImpl implements TopBooksService {

    @Autowired
    TopBooksRepository topBooksRepository;


    @Override
    public Page<TopBooks> getAll(Pageable pageable) {
        return topBooksRepository.findAll(pageable);
    }

    @Override
    public TopBooks create(TopBooks data) {
        return topBooksRepository.save(data);
    }

    @Override
    public TopBooks update(TopBooks data) {
        return topBooksRepository.save(data);
    }

    @Override
    public void delete(TopBooks data) {
        topBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        topBooksRepository.deleteById(id);

    }

    @Override
    public Page<TopBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n=Long.parseLong(key);
            int i=Integer.parseInt(key);
            return topBooksRepository.findAllByNameContainsIgnoreCaseOrId(key ,n ,pageable);
        }
        catch (Exception e) {
            return topBooksRepository.findAllByNameContainsIgnoreCaseOrId(key ,(long) -1,pageable);
        }
    }
}
