package Login.login.demo.controller;

import Login.login.demo.entity.FileStorge;
import Login.login.demo.repository.FileStorgeRepository;
import Login.login.demo.service.FileStoregeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/file")
public class FileStoregeController {


    @Autowired
    FileStoregeService fileStoregeService;
    @Autowired
    FileStorgeRepository fileStorgeRepository;

    public FileStoregeController(FileStoregeService fileStorageService) {
        this.fileStoregeService = fileStorageService;
    }


    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile multipartFile) {
        fileStoregeService.save(multipartFile);
        return multipartFile.getOriginalFilename() + "file saqlandi";
    }


    @GetMapping("/download/{filename}")
    public ResponseEntity downloadFile(@PathVariable("filename") String hashId) throws IOException {

        FileStorge fileStorage = fileStoregeService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getUploadPath())));
    }

    @DeleteMapping("/delete/{hashId}")
    public FileStorge delete(@PathVariable String hashId) {
        fileStoregeService.delete(hashId);
        return fileStoregeService.findByHashId("fayl o'chirildi");


    }


}
