package org.example.ems.service;

import org.example.ems.model.Item;
import org.example.ems.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService {


    private  final String uploadDir ;

    public FileUploadService(@Value("${app.file.upload-dir}") String uploadDir) {
        this.uploadDir = uploadDir;
    }

    @Autowired
    private ItemRepo itemRepo ;


    public String uploadFile(MultipartFile file) throws IOException {
        try {
            if (!file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                String uniquerFileName = UUID.randomUUID() + "_" + originalFilename;
                Path targetLocation = Paths.get(uploadDir).resolve(uniquerFileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                return uniquerFileName;
            }else {
                return  "file is empty";
            }
        } catch (IOException e) {
            throw new IOException("file is empty", e);
        }
    }
    public Item createItem(String title , MultipartFile file) throws IOException {
        String photoPath = uploadFile(file);
        Item item = new Item(title , photoPath);
        return  itemRepo.save(item);
    }
}
