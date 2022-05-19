package com.pharma.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "med_search_request_text")
@NamedQuery(name = "MedSearchRequestText.findAll", query = "SELECT m FROM MedSearchRequestText m")

public class MedSearchRequestText {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="medsearchreqtextsequence")
	@SequenceGenerator(name = "medsearchreqtextsequence", sequenceName = "medsearchreqtextsequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id", updatable=false)
	private Long id;

	@Column(name = "created_date")
	private Timestamp createdDate;

	private double qty;

	@Column(name = "record_status")
	private Integer recordStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "med_search_request_id")
	private MedSearchRequest medSearchRequest;

	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "id")
	private Medicine medicine;

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

 

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public MedSearchRequest getMedSearchRequest() {
		return medSearchRequest;
	}

	public void setMedSearchRequest(MedSearchRequest medSearchRequest) {
		this.medSearchRequest = medSearchRequest;
	}

}
