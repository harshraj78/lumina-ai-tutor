package com.lumina.api.controller;

import com.lumina.api.model.Document;
import com.lumina.api.repository.DocumentRepository;
import com.lumina.api.service.FileStorageService;
import com.lumina.api.service.PdfService; // Import the new service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final FileStorageService storageService;
    private final DocumentRepository documentRepository;
    private final PdfService pdfService; // Inject the PDF reader

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        // 1. Save the file physically
        String finalPath = storageService.saveFile(file);

        // 2. Save the metadata to PostgreSQL
        Document doc = new Document();
        doc.setFileName(file.getOriginalFilename());
        doc.setFilePath(finalPath);
        doc.setContentType(file.getContentType());
        documentRepository.save(doc);

        // 3. READ THE TEXT (The new part!)
        String extractedText = pdfService.extractText(finalPath);

        // Print it to your console so you can see it
        System.out.println("--- EXTRACTED TEXT START ---");
        System.out.println(extractedText);
        System.out.println("--- EXTRACTED TEXT END ---");

        return "File uploaded and read successfully! Check your IntelliJ console.";
    }
}