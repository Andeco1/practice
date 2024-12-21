package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
        try {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(" ");
                }
            }

            session.setAttribute("fileContent", content.toString());

        } catch (Exception e) {
        }

        return "redirect:/home";
    }

    @PostMapping("/search")
    public String search(@RequestParam("query") String query, Model model, HttpSession session) {
        String fileContent = (String) session.getAttribute("fileContent");

        if (fileContent == null || fileContent.isEmpty()) {
            model.addAttribute("message", "Файл не загружен. Сначала загрузите файл.");
            return "home";
        }

        List<String> results = findKeywordInContext(fileContent, query);

        model.addAttribute("query", query);
        model.addAttribute("results", results);
        return "home";
    }

    private List<String> findKeywordInContext(String content, String keyword) {
        List<String> results = new ArrayList<>();
        String[] words = content.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(keyword)) {
                StringBuilder result = new StringBuilder();
                int start = Math.max(0, i - 2);
                int end = Math.min(words.length - 1, i + 2);

                for (int j = start; j < i; j++) {
                    result.append(words[j]).append(" ");
                }
                result.append(words[i]).append(" ");
                for (int j = i + 1; j <= end; j++) {
                    result.append(words[j]).append(" ");
                }
                results.add(result.toString().trim());
            }
        }
        return results;
    }
}
