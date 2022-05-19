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
@Table(name="med_search_request_image")
@NamedQuery(name="MedSearchRequestImage.findAll", query="SELECT m FROM MedSearchRequestImage m")

public class MedSearchRequestImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="created_date")
	private Timestamp createdDate;

	private double qty;

	@Column(name="record_status")
	private Integer recordStatus;
	
	@Column(name="prescription_url")
	private String prescriptionUrl;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private List<MedSearchRequest> medSearchRequests = new ArrayList<>();
	
 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public List<MedSearchRequest> getMedSearchRequests() {
		return medSearchRequests;
	}

	public void setMedSearchRequests(List<MedSearchRequest> medSearchRequests) {
		this.medSearchRequests = medSearchRequests;
	}

	public String getPrescriptionUrl() {
		return prescriptionUrl;
	}

	public void setPrescriptionUrl(String prescriptionUrl) {
		this.prescriptionUrl = prescriptionUrl;
	}

 

}
