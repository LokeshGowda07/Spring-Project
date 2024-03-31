package com.loki.Jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loki.Jobportal.dto.PortalUser;

public interface JobPortalRepository extends JpaRepository<PortalUser, Integer> {
  boolean existsByEmail(String email);
}
