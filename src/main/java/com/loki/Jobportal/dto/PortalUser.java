package com.loki.Jobportal.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Component
@Entity
public class PortalUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=3,max=15,message="Enter between 3~15 characters")
	private String name;
	@NotEmpty(message="this field is required")
	@Email(message="Not a vaild email format")
	private String email;
	@DecimalMin(value = "6000000000", message="Enter proper Mobile number")
	@DecimalMax(value = "9999999999", message="Enter proper Mobile number")
	private long mobile;
	@NotNull(message="this field is required")
	private LocalDate dob;
	@Size(min=8,max=15,message="Enter between 8~15 characters")
	private String password;
	@Size(min=8,max=15,message="Enter between 8~15 characters")
	private String confirm_password;
	@NotNull(message="this field is required")
	private String role;
	

}
