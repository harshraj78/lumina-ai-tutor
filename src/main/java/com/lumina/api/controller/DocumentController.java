package com.lumina.api.controller;

import com.lumina.api.model.Document;
import com.lumina.api.repository.DocumentRepository;
import com.lumina.api.service.FileStorageService;
import com.lumina.api.service.PdfService;
import com.lumina.api.service.AiTutorService; // Import the AI service
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final FileStorageService storageService;
    private final DocumentRepository documentRepository;
    private final PdfService pdfService;
    private final AiTutorService aiTutorService; // Add this line

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        // 1. Save the file physically in 'lumina-uploads'
        String finalPath = storageService.saveFile(file);

        // 2. Save metadata to PostgreSQL
        Document doc = new Document();
        doc.setFileName(file.getOriginalFilename());
        doc.setFilePath(finalPath);
        doc.setContentType(file.getContentType());
        documentRepository.save(doc);

        // 3. Extract the text from the PDF
        String extractedText = pdfService.extractText(finalPath);

        // 4. Send that text to your local Ollama AI for a summary
        String summary = aiTutorService.summarizeLesson(extractedText);

        // 5. Return the summary to Postman
        return "UPLOAD SUCCESSFUL!\n\nAI SUMMARY:\n" + summary;
    }
}