package Login.login.demo.service.Impl;

import Login.login.demo.entity.WorldBooks;
import Login.login.demo.repository.WorldBooksRepository;
import Login.login.demo.service.WorldBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WorlbooksImpl implements WorldBooksService {

    @Autowired
    WorldBooksRepository worldBooksRepository;

    @Override
    public Page<WorldBooks> getAll(Pageable pageable) {
        return worldBooksRepository.findAll(pageable);
    }

    @Override
    public WorldBooks create(WorldBooks data) {
        return worldBooksRepository.save(data);
    }

    @Override
    public WorldBooks update(WorldBooks data) {
        return worldBooksRepository.save(data);
    }

    @Override
    public void delete(WorldBooks data) {
        worldBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        worldBooksRepository.deleteById(id);

    }

    @Override
    public Page<WorldBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n=Long.parseLong(key);
            int i=Integer.parseInt(key);
            return worldBooksRepository.findAllByNameContainsIgnoreCaseOrId(key , n,pageable);
        }
        catch (Exception e) {
            return worldBooksRepository.findAllByNameContainsIgnoreCaseOrId(key,(long) -1,pageable);
        }
    }
}
