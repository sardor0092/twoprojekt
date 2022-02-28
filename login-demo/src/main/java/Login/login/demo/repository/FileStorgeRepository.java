package Login.login.demo.repository;

import Login.login.demo.entity.FileStorge;
import Login.login.demo.entity.activevsdrive.FileStorgeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorgeRepository  extends JpaRepository<FileStorge ,Long> {

    FileStorge findByHashId(String hashId);

    List<FileStorge> findAllByFileStorageStatus(FileStorgeStatus status);


}
