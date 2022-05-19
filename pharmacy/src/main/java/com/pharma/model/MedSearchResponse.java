package com.pharma.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "med_search_response")
@NamedQuery(name = "MedSearchResponse.findAll", query = "SELECT m FROM MedSearchResponse m")

public class MedSearchResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="address")
	private String address;

	@Column(name="contact_number")
	private Integer contactNumber;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="prescription_url")
	private String prescriptionUrl;

	@Column(name="record_status")
	private Integer recordStatus;

	@Column(name="request_prescription")
	private Boolean requestPrescription;

	@Column(name="total_amount_in_points")
	private Integer totalAmountInPoints;

	@Column(name="user_id")
	private Long userId;
	
	@OneToMany(mappedBy = "medSearchResponse", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<MedSearchResponseText> medSearchResponseTexts = new ArrayList<>();
	

	public List<MedSearchResponseText> getMedSearchResponseTexts() {
		return medSearchResponseTexts;
	}

	public void setMedSearchResponseTexts(List<MedSearchResponseText> medSearchResponseTexts) {
		this.medSearchResponseTexts = medSearchResponseTexts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getPrescriptionUrl() {
		return prescriptionUrl;
	}

	public void setPrescriptionUrl(String prescriptionUrl) {
		this.prescriptionUrl = prescriptionUrl;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Boolean getRequestPrescription() {
		return requestPrescription;
	}

	public void setRequestPrescription(Boolean requestPrescription) {
		this.requestPrescription = requestPrescription;
	}

	public Integer getTotalAmountInPoints() {
		return totalAmountInPoints;
	}

	public void setTotalAmountInPoints(Integer totalAmountInPoints) {
		this.totalAmountInPoints = totalAmountInPoints;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
 
}
