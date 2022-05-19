package com.pharma.vo;

import java.util.ArrayList;

public class PharmacySearchRequestVo {

	private Long user_id;
	private Integer distance_limit;
	private boolean is_image;
	ArrayList<MedicineSearchRequestVo> medicines = new ArrayList<MedicineSearchRequestVo>();

	// Getter Methods

	public Long getUser_id() {
		return user_id;
	}

	public Integer getDistance_limit() {
		return distance_limit;
	}

	public boolean getIs_image() {
		return is_image;
	}

	// Setter Methods

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setDistance_limit(Integer distance_limit) {
		this.distance_limit = distance_limit;
	}

	public void setIs_image(boolean is_image) {
		this.is_image = is_image;
	}
	public ArrayList<MedicineSearchRequestVo> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<MedicineSearchRequestVo> medicines) {
		this.medicines = medicines;
	}

}
