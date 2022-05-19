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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "med_search_response_text")
public class MedSearchResponseText {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "amount_in_points")
	private Integer amountInPoints;

	@Column(name = "created_date")
	private Timestamp createdDate;

	private double qty;

	@Column(name = "record_status")
	private Integer recordStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "med_search_response_id")
	private MedSearchResponse medSearchResponse;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private List<Medicine> medicines = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmountInPoints() {
		return amountInPoints;
	}

	public void setAmountInPoints(Integer amountInPoints) {
		this.amountInPoints = amountInPoints;
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

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public MedSearchResponse getMedSearchResponse() {
		return medSearchResponse;
	}

	public void setMedSearchResponse(MedSearchResponse medSearchResponse) {
		this.medSearchResponse = medSearchResponse;
	}
}
