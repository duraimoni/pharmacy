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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "med_search_request_pharmacy")
@NamedQuery(name = "MedSearchRequestPharmacy.findAll", query = "SELECT m FROM MedSearchRequestPharmacy m")

public class MedSearchRequestPharmacy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "created_date")
	private Timestamp createdDate;
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "record_status")
	private Integer recordStatus;

	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "id")
	private MedSearchRequest medSearchRequest;

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

 
	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	 

	public MedSearchRequest getMedSearchRequest() {
		return medSearchRequest;
	}

	public void setMedSearchRequest(MedSearchRequest medSearchRequest) {
		this.medSearchRequest = medSearchRequest;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
 

}
