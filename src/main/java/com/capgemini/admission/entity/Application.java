package com.capgemini.admission.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

	@Id
	@GeneratedValue
	private Integer applicationId;
	private String applicantFullName;
	private LocalDate dateOfBirth;
	private String highestQualification;
	private double finalYearPercentage;
	private String emailId;
	private String applicationStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Payment_id")
	private Payment payment;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Integer applicationId, String applicantFullName, LocalDate dateOfBirth,
			String highestQualification, double finalYearPercentage, String emailId, String applicationStatus,
			Payment payment) {
		super();
		this.applicationId = applicationId;
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.emailId = emailId;
		this.applicationStatus = applicationStatus;
		this.payment = payment;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public double getFinalYearPercentage() {
		return finalYearPercentage;
	}

	public void setFinalYearPercentage(double finalYearPercentage) {
		this.finalYearPercentage = finalYearPercentage;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
				+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
				+ ", finalYearPercentage=" + finalYearPercentage + ", emailId=" + emailId + ", applicationStatus="
				+ applicationStatus + ", payment=" + payment + "]";
	}

}
