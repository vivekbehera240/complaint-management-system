package com.cms.complaintsystem.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {

    // =============================
    // CATEGORY DETECTION
    // =============================
    public String categorizeComplaint(String text) {

        if (text == null || text.isEmpty()) {
            return "GENERAL";
        }

        text = text.toLowerCase();

        List<String> categories = new ArrayList<>();

        // AC problems
        if (text.contains("ac") || text.contains("air conditioner") || text.contains("air conditioning")) {
            categories.add("AC");
        }

        // Food problems
        if (text.contains("food") || text.contains("canteen") || text.contains("mess")) {
            categories.add("FOOD");
        }

        // Furniture problems
        if (text.contains("chair") || text.contains("table") || text.contains("bench")) {
            categories.add("FURNITURE");
        }

        // Electrical problems
        if (text.contains("light") || text.contains("electric") || text.contains("fan")) {
            categories.add("ELECTRICAL");
        }

        // Cleaning problems
        if (text.contains("dirty") || text.contains("clean") || text.contains("garbage")) {
            categories.add("CLEANING");
        }

        // Network problems
        if (text.contains("wifi") || text.contains("internet") || text.contains("network")) {
            categories.add("NETWORK");
        }

        // Default category
        if (categories.isEmpty()) {
            categories.add("GENERAL");
        }

        // Convert list → "AC, FOOD"
        return String.join(", ", categories);
    }


    // =============================
    // DEPARTMENT AUTO ASSIGN
    // =============================
    public String detectDepartment(String text) {

        if (text == null || text.isEmpty()) {
            return "General";
        }

        text = text.toLowerCase();

        // Maintenance Department
        if (text.contains("ac") || text.contains("fan") || text.contains("cooling")) {
            return "Maintenance";
        }

        // Canteen Department
        if (text.contains("food") || text.contains("canteen") || text.contains("mess")) {
            return "Canteen";
        }

        // IT Department
        if (text.contains("wifi") || text.contains("internet") || text.contains("network")) {
            return "IT";
        }

        // Electrical Department
        if (text.contains("light") || text.contains("electric") || text.contains("power")) {
            return "Electrical";
        }

        // Housekeeping Department
        if (text.contains("clean") || text.contains("dirty") || text.contains("garbage")) {
            return "Housekeeping";
        }

        return "General";
    }
}