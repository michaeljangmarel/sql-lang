package org.example.ems.api;

import org.example.ems.model.Item;
import org.example.ems.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/save")
public class FileUpload {

    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/file")
    public ResponseEntity<Item> saveItem(@RequestParam("title") String title , @RequestParam("file") MultipartFile file ) throws IOException {
        Item item = fileUploadService.createItem(title,file);
        return ResponseEntity.ok(item);
    }
}
