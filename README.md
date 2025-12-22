# Lumina – AI-Powered Learning Management System (LMS) 🎓🤖

Lumina is a next-generation LMS designed to prioritize student privacy and interactive learning. By leveraging **Local LLMs**, Lumina allows students to upload educational PDFs and interact with an AI Tutor that provides summaries and answers questions without ever sending data to the cloud.

---

## 🌟 Key Features
* **Private AI Tutoring:** Uses local models (Ollama/Phi-3) to ensure 100% data privacy.
* **RAG Integration:** Implements Retrieval-Augmented Generation to provide context-aware summaries from uploaded documents.
* **Secure Document Vault:** Robust file management system using PostgreSQL for metadata and local storage for PDFs.
* **User Authentication:** Secure signup/login system with BCrypt password hashing.

---

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot 3.3.
* **AI Engine:** Spring AI, Ollama (Phi-3/Llama 3).
* **Database:** PostgreSQL.
* **Tools:** Apache PDFBox (Text Extraction), Gradle, Git.

---

## 🚀 How to Run Locally

### Prerequisites
1. **Ollama:** Install from [ollama.com](https://ollama.com) and run `ollama run phi3`.
2. **PostgreSQL:** Ensure you have a database named `lumina_db` running.

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/harshraj78/lumina-ai-tutor.git](https://github.com/harshraj78/lumina-ai-tutor.git)
2. Update `src/main/resources/application.properties` with your PostgreSQL credentials.
3. Run the application via IntelliJ IDEA or using: `./gradlew bootRun`

## 📸 API Preview
* **POST** `/api/v1/documents/upload` - Upload a PDF and receive an AI-generated summary.
* **POST `/api/v1/chat` - Chat with the AI regarding the uploaded content (Coming Soon).