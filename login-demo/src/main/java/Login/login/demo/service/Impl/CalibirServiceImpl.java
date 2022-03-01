package Login.login.demo.service.Impl;

import Login.login.demo.entity.CalibirBooks;
import Login.login.demo.repository.CalibirRepository;
import Login.login.demo.service.CalibiBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CalibirServiceImpl implements CalibiBooksService {

    @Autowired
    CalibirRepository calibirRepository;


    @Override
    public Page<CalibirBooks> getAll(Pageable pageable) {
        return calibirRepository.findAll(pageable);
    }

    @Override
    public CalibirBooks create(CalibirBooks data) {
        return calibirRepository.save(data);
    }

    @Override
    public CalibirBooks update(CalibirBooks data) {
        return calibirRepository.save(data);
    }

    @Override
    public void delete(CalibirBooks data) {
        calibirRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        calibirRepository.deleteById(id);

    }

    @Override
    public Page<CalibirBooks> findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n=Long.parseLong(key);
            int i =Integer.parseInt(key);
            return calibirRepository.findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId( key, key ,n ,pageable);
        }
        catch (Exception e) {
            return calibirRepository.findAllByNameContainsIgnoreCaseOrFamiliyaContainsIgnoreCaseOrId(key ,key ,(long)-1,pageable);
        }
    }
}
