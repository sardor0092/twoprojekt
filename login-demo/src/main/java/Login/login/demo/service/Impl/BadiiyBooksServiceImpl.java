package Login.login.demo.service.Impl;

import Login.login.demo.entity.BaddiyBooks;
import Login.login.demo.repository.BadiiyBooksRepository;
import Login.login.demo.service.BadiiyBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BadiiyBooksServiceImpl implements BadiiyBooksService {

    @Autowired
    BadiiyBooksRepository badiiyBooksRepository;

    @Override
    public Page<BaddiyBooks> getAll(Pageable pageable) {
        return badiiyBooksRepository.findAll(pageable);
    }

    @Override
    public BaddiyBooks create(BaddiyBooks data) {
        return badiiyBooksRepository.save(data);
    }

    @Override
    public BaddiyBooks update(BaddiyBooks data) {
        return badiiyBooksRepository.save(data);
    }

    @Override
    public void delete(BaddiyBooks data) {

        badiiyBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        badiiyBooksRepository.deleteById(id);

    }

    @Override
    public Page<BaddiyBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n=Long.parseLong(key);
            int i=Integer.parseInt(key);
            return badiiyBooksRepository.findAllByNameContainsIgnoreCaseOrId(key ,n ,pageable);
        }
        catch (Exception e) {
            return badiiyBooksRepository.findAllByNameContainsIgnoreCaseOrId(key , (long) -1,pageable);
        }
    }
}
