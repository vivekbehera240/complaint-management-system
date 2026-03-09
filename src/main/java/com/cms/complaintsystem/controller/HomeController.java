package com.cms.complaintsystem.controller;

import com.cms.complaintsystem.model.Complaint;
import com.cms.complaintsystem.repository.ComplaintRepository;
import com.cms.complaintsystem.service.AIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private ComplaintRepository repository;

    @Autowired
    private AIService aiService;

    // =============================
    // OPEN LOGIN PAGE FIRST
    // =============================
    @GetMapping("/")
    public String start() {
        return "login";
    }

    // =============================
    // LOGIN PAGE
    // =============================
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // =============================
    // LOGIN PROCESS
    // =============================
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        // ADMIN LOGIN
        if(username.equals("admin") && password.equals("admin123")) {
            return "redirect:/admin";
        }

        // USER LOGIN
        if(username.equals("user") && password.equals("user123")) {
            return "redirect:/home";
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // =============================
    // USER HOME PAGE
    // =============================
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    // =============================
    // TRACK PAGE
    // =============================
    @GetMapping("/track")
    public String trackPage() {
        return "track";
    }

    // =============================
    // TRACK COMPLAINT
    // =============================
    @PostMapping("/track")
    public String trackComplaint(@RequestParam("id") Long id, Model model) {

        Complaint complaint = repository.findById(id).orElse(null);

        model.addAttribute("complaint", complaint);

        return "track";
    }

    // =============================
    // SUBMIT COMPLAINT
    // =============================
    @PostMapping("/submit")
    public String submitComplaint(@RequestParam("complaint") String text,
                                  @RequestParam("image") MultipartFile file,
                                  Model model) throws IOException {

        Complaint complaint = new Complaint();

        complaint.setText(text);
        complaint.setStatus("Pending");

        // AI CATEGORY
        String category = aiService.categorizeComplaint(text);
        complaint.setCategory(category);

        // AI DEPARTMENT
        String department = aiService.detectDepartment(text);
        complaint.setDepartment(department);

        // IMAGE UPLOAD
        if (!file.isEmpty()) {

            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = uploadDir + file.getOriginalFilename();
            File destination = new File(filePath);

            file.transferTo(destination);

            complaint.setImagePath(filePath);
        }

        repository.save(complaint);

        model.addAttribute("complaintId", complaint.getId());
        model.addAttribute("category", category);
        model.addAttribute("department", department);

        return "success";
    }
}