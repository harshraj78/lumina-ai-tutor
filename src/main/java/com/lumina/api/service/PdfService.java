package com.lumina.api.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;

@Service
public class PdfService {

    public String extractText(String filePath) throws IOException {
        // 1. Load the file from your 'lumina-uploads' folder
        File file = new File(filePath);

        // 2. Open the PDF
        try (PDDocument document = Loader.loadPDF(file)) {
            // 3. Use the 'Stripper' to pull out all the text
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}