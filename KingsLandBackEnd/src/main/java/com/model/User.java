package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity

public class User implements Serializable {
	
      @Id
      @NotEmpty
      @Email(message="Enter valid Email-id")
      private String email;
      
      @NotNull
      @NotEmpty(message = "Please enter your Name.")
      private String name;
      
      @NotEmpty(message = "Please enter your password.")
      @Size(min = 4, max = 10, message = "Your password must between 4 and 10 characters")
      private String password;
      
      private String role;
      
      @NotEmpty (message = "Please enter your Address.")
      private String address;
      
      @NotEmpty(message = "Please enter your Number.")
      @Size(min = 10, max = 10, message = "Your number must be 10 digits")
      @Pattern(regexp="(^$|[0-9]{10})")
      private String phone;
      
      
      private boolean enabled;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
      
      
      


}
