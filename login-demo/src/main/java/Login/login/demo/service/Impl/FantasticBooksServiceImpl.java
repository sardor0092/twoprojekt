package Login.login.demo.service.Impl;

import Login.login.demo.entity.FantasticBooks;
import Login.login.demo.repository.FantasticBooksRepository;
import Login.login.demo.service.FantasticBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FantasticBooksServiceImpl implements FantasticBooksService {

    @Autowired
    FantasticBooksRepository fantasticBooksRepository;



    @Override
    public Page<FantasticBooks> getAll(Pageable pageable) {
        return fantasticBooksRepository.findAll(pageable);
    }

    @Override
    public FantasticBooks create(FantasticBooks data) {
        return fantasticBooksRepository.save(data);
    }

    @Override
    public FantasticBooks update(FantasticBooks data) {
        return fantasticBooksRepository.save(data);
    }

    @Override
    public void delete(FantasticBooks data) {
        fantasticBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        fantasticBooksRepository.deleteById(id);

    }
    @Override
    public Page<FantasticBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n=Long.parseLong(key);
            int i=Integer.parseInt(key);
            return fantasticBooksRepository.findAllByNameContainsIgnoreCaseOrId( key,n ,pageable);
        }
        catch (Exception e){
            return fantasticBooksRepository.findAllByNameContainsIgnoreCaseOrId(key,(long) -1 ,pageable);
        }
    }

}
