package com.cms.complaintsystem.controller;

import com.cms.complaintsystem.model.Complaint;
import com.cms.complaintsystem.repository.ComplaintRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    ComplaintRepository repository;

    // Admin Dashboard
    @GetMapping("/admin")
    public String adminDashboard(Model model) {

        List<Complaint> complaints = repository.findAll();

        int total = complaints.size();

        long pending = complaints.stream()
                .filter(c -> "Pending".equals(c.getStatus()))
                .count();

        long resolved = complaints.stream()
                .filter(c -> "Resolved".equals(c.getStatus()))
                .count();

        model.addAttribute("complaints", complaints);
        model.addAttribute("total", total);
        model.addAttribute("pending", pending);
        model.addAttribute("resolved", resolved);

        return "admin";
    }

    // Resolve Complaint
    @GetMapping("/resolve/{id}")
    public String resolveComplaint(@PathVariable Long id) {

        Complaint complaint = repository.findById(id).orElse(null);

        if (complaint != null) {
            complaint.setStatus("Resolved");
            repository.save(complaint);
        }

        return "redirect:/admin";
    }

    // Delete Complaint
    @GetMapping("/delete/{id}")
    public String deleteComplaint(@PathVariable Long id) {

        repository.deleteById(id);

        return "redirect:/admin";
    }
}