package com.pharma.vo;

import java.util.ArrayList;

public class SearchResponseRequestVo {
	private float med_search_request_pharmacy_id;
	private boolean request_prescription;
	private float total_amount_in_points;
	ArrayList<Object> medicines = new ArrayList<Object>();
	
	public float getMed_search_request_pharmacy_id() {
		return med_search_request_pharmacy_id;
	}
	public boolean isRequest_prescription() {
		return request_prescription;
	}
	public float getTotal_amount_in_points() {
		return total_amount_in_points;
	}
	public ArrayList<Object> getMedicines() {
		return medicines;
	}
	public void setMed_search_request_pharmacy_id(float med_search_request_pharmacy_id) {
		this.med_search_request_pharmacy_id = med_search_request_pharmacy_id;
	}
	public void setRequest_prescription(boolean request_prescription) {
		this.request_prescription = request_prescription;
	}
	public void setTotal_amount_in_points(float total_amount_in_points) {
		this.total_amount_in_points = total_amount_in_points;
	}
	public void setMedicines(ArrayList<Object> medicines) {
		this.medicines = medicines;
	}

}
