package com.lumina.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageService {

    // Define where the files will sit on your computer
    private final Path rootPath = Paths.get("lumina-uploads");

    public String saveFile(MultipartFile file) throws IOException {
        // 1. Create the folder if it doesn't exist
        if (!Files.exists(rootPath)) {
            Files.createDirectories(rootPath);
        }

        // 2. Generate the unique UUID name you suggested!
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueName = UUID.randomUUID().toString() + fileExtension;

        // 3. Save the file to the folder
        Path targetPath = rootPath.resolve(uniqueName);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return targetPath.toString(); // Return the "Address" to save in DB
    }
}