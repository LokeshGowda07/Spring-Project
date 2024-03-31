package com.loki.Jobportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loki.Jobportal.repository.JobPortalRepository;
@Component
public class PortalUserDao {
@Autowired
JobPortalRepository repository;

public boolean existsByEmail(String email) {
	return repository.existsByEmail(email);
	
}



}
