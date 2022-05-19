package com.pharma.service;

import java.util.List;
import java.util.Optional;

import com.pharma.model.MedSearchRequest;
import com.pharma.model.MedSearchRequestPharmacy;
import com.pharma.model.MedSearchRequestText;
import com.pharma.model.Medicine;
import com.pharma.vo.PharmacySearchRequestVo;

public interface PharmacyService {
	public Optional<List<Medicine>> getMedicines(String medicineName);

	public List<MedSearchRequest> getMedicinesRequest();

	public List<MedSearchRequestText> getMedicinesRequestText();
	
	public Long saveSearchRequestText(PharmacySearchRequestVo  pharmacySearchRequestVo);
	

	public List<MedSearchRequestPharmacy> findByMedicineName(String medicineName);
}
