package com.pharma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.model.MedSearchRequest;
import com.pharma.model.MedSearchRequestPharmacy;
import com.pharma.model.MedSearchRequestText;
import com.pharma.model.Medicine;
import com.pharma.repository.MedSearchRequestPharmacyRepository;
import com.pharma.repository.MedSearchRequestRepository;
import com.pharma.repository.MedSearchRequestTextRepository;
import com.pharma.repository.MedicineRepository;
import com.pharma.vo.MedicineSearchRequestVo;
import com.pharma.vo.PharmacySearchRequestVo;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	@Autowired
	private MedicineRepository medicineRepository;

	@Autowired
	private MedSearchRequestRepository MedSearchRequestRepository;

	@Autowired
	private MedSearchRequestTextRepository medSearchRequestTextRepository;
	
	@Autowired
	private MedSearchRequestPharmacyRepository medSearchRequestPharmacyRepository;

	@Override
	public Optional<List<Medicine>> getMedicines(String medicineName) {
		return Optional.of(medicineRepository.findByMedicineName(medicineName));
	}

	public List<MedSearchRequest> getMedicinesRequest() {
		return MedSearchRequestRepository.findAll();
	}

	public List<MedSearchRequestText> getMedicinesRequestText() {
		return medSearchRequestTextRepository.findAll();
	}

	@Override
	public Long saveSearchRequestText(PharmacySearchRequestVo pharmacySearchRequestVo) {
		MedSearchRequest medSearchRequest =  syncSearchRequestVoToBO( pharmacySearchRequestVo);
		medSearchRequest = MedSearchRequestRepository.save(medSearchRequest);
		return medSearchRequest.getId();
	}

	private MedSearchRequest syncSearchRequestVoToBO(PharmacySearchRequestVo pharmacySearchRequestVo) {
		MedSearchRequest request = new MedSearchRequest();
		request.setDistanceLimit(pharmacySearchRequestVo.getDistance_limit());
		request.setIsImage(pharmacySearchRequestVo.getIs_image());
		request.setRecordStatus(1);
		request.setUserId(pharmacySearchRequestVo.getUser_id());
		request.setUrgency(1);
		
		List<MedSearchRequestText> searchRequestLst = new ArrayList<MedSearchRequestText>();
		for(MedicineSearchRequestVo vo : pharmacySearchRequestVo.getMedicines()) {
			MedSearchRequestText text = new MedSearchRequestText();
			Medicine medicine = new Medicine();
			medicine.setId(vo.getId());
			text.setMedicine(medicine);
			text.setQty(vo.getQty());
			searchRequestLst.add(text);
		}
		request.setMedSearchRequestTexts(searchRequestLst);
	 
		return request;
	}

	@Override
	public List<MedSearchRequestPharmacy> findByMedicineName(String medicineName) {
		return medSearchRequestPharmacyRepository.findByMedicineName(medicineName);
	}

}
