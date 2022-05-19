package com.pharma.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="med_search_request")
@NamedQuery(name="MedSearchRequest.findAll", query="SELECT m FROM MedSearchRequest m")
public class MedSearchRequest {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="medsearchreqsequence")
	@SequenceGenerator(name = "medsearchreqsequence", sequenceName = "medsearchreqsequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id", updatable=false)
	private Long id;

	@Column(name="created_date")
	private Time createdDate_;

	@Column(name="distance_limit")
	private Integer distanceLimit;

	@Column(name="is_image")
	private Boolean isImage;

	@Column(name="record_status")
	private Integer recordStatus;

	private Integer urgency;

	@Column(name="user_id")
	private Long userId;
	
	@OneToMany(mappedBy = "medSearchRequest", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	private List<MedSearchRequestText> medSearchRequestTexts;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getCreatedDate_() {
		return createdDate_;
	}

	public void setCreatedDate_(Time createdDate_) {
		this.createdDate_ = createdDate_;
	}

	public Integer getDistanceLimit() {
		return distanceLimit;
	}

	public void setDistanceLimit(Integer distanceLimit) {
		this.distanceLimit = distanceLimit;
	}

	public Boolean getIsImage() {
		return isImage;
	}

	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Integer getUrgency() {
		return urgency;
	}

	public void setUrgency(Integer urgency) {
		this.urgency = urgency;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<MedSearchRequestText> getMedSearchRequestTexts() {
		return medSearchRequestTexts;
	}

	public void setMedSearchRequestTexts(List<MedSearchRequestText> medSearchRequestTexts) {
		this.medSearchRequestTexts = medSearchRequestTexts;
	}
}
