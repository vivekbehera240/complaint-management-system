package com.cms.complaintsystem.model;

import jakarta.persistence.*;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String category;

    private String department;

    private String status;

    private String imagePath;

    // =============================
    // GET ID
    // =============================
    public Long getId() {
        return id;
    }

    // SET ID
    public void setId(Long id) {
        this.id = id;
    }

    // =============================
    // GET TEXT
    // =============================
    public String getText() {
        return text;
    }

    // SET TEXT
    public void setText(String text) {
        this.text = text;
    }

    // =============================
    // GET CATEGORY
    // =============================
    public String getCategory() {
        return category;
    }

    // SET CATEGORY
    public void setCategory(String category) {
        this.category = category;
    }

    // =============================
    // GET DEPARTMENT
    // =============================
    public String getDepartment() {
        return department;
    }

    // SET DEPARTMENT
    public void setDepartment(String department) {
        this.department = department;
    }

    // =============================
    // GET STATUS
    // =============================
    public String getStatus() {
        return status;
    }

    // SET STATUS
    public void setStatus(String status) {
        this.status = status;
    }

    // =============================
    // GET IMAGE PATH
    // =============================
    public String getImagePath() {
        return imagePath;
    }

    // SET IMAGE PATH
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}