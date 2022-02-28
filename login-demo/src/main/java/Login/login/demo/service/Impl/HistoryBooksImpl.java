package Login.login.demo.service.Impl;

import Login.login.demo.entity.HistoryBooks;
import Login.login.demo.repository.HistoryBooksRepository;
import Login.login.demo.service.HistoryBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoryBooksImpl implements HistoryBooksService {

    @Autowired
    HistoryBooksRepository historyBooksRepository;

    @Override
    public Page<HistoryBooks> getAll(Pageable pageable) {
        return historyBooksRepository.findAll(pageable);
    }

    @Override
    public HistoryBooks create(HistoryBooks data) {
        return historyBooksRepository.save(data);
    }

    @Override
    public HistoryBooks update(HistoryBooks data) {
        return historyBooksRepository.save(data);
    }

    @Override
    public void delete(HistoryBooks data) {
        historyBooksRepository.delete(data);

    }

    @Override
    public void deleteById(Long id) {
        historyBooksRepository.deleteById(id);

    }

    @Override
    public Page<HistoryBooks> findAllByNameContainsIgnoreCaseOrId(String key, Pageable pageable) {
        try {
            Long n = Long.parseLong(key);
            int i = Integer.parseInt(key);
            return historyBooksRepository.findAllByNameContainsIgnoreCaseOrId(key, n, pageable);
        } catch (Exception e) {
            return historyBooksRepository.findAllByNameContainsIgnoreCaseOrId(key, (long) -1, pageable);
        }
    }
}
