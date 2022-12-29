package com.capgemini.admission.dto;

import java.io.Serializable;
import javax.validation.constraints.*;


public class UserDTO {

	private int userId;
	@NotBlank(message = "The first name field should not be blank")
	@Size(min=3, max=150)
	private String firstName;
	private String middleName;
	private String lastName;
	@NotNull(message="the email should not be blank,empty or null")
	@Email(message = "Please enter valid email id ",regexp= "[a-zA-z._-]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,5}")
	private String email;
	private String mobileNumber;
	private String aadharCardNo;
	@NotBlank(message = "The password field should not be blank")
	@Size(min=5, max=15)
	private String password;
	private String role;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAadharCardNo() {
		return aadharCardNo;
	}
	public void setAadharCardNo(String aadharCardNo) {
		this.aadharCardNo = aadharCardNo;
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
	

}
