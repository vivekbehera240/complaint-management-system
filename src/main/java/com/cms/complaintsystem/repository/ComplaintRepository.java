package com.cms.complaintsystem.repository;

import com.cms.complaintsystem.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
