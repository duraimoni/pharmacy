package com.pharma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.service.PharmacyService;
import com.pharma.vo.PharmacySearchRequestVo;
import com.pharma.vo.ResponseObject;
import com.pharma.vo.SearchResponseRequestVo;

@RestController
@RequestMapping("pharmacy")
public class PharmacyController {
	@Autowired
	private PharmacyService pharmacyService;

	@PostMapping("med_search_request_texts")
	public ResponseEntity<ResponseObject> saveSearchRequest(
			@RequestBody PharmacySearchRequestVo pharmacySearchRequestVo) {
		Long val = pharmacyService.saveSearchRequestText(pharmacySearchRequestVo);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("success", "med_search_request_id :" + val));
	}

	@GetMapping("med_search_request_pharmacy")
	public ResponseEntity<ResponseObject> getMedicines(@RequestParam("q") String medicineName,
			@RequestParam("status") String status) { // @Size(min = 3,
		pharmacyService.findByMedicineName(medicineName);
		if (medicineName.length() < 3) {
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body(
					new ResponseObject(HttpStatus.METHOD_FAILURE.getReasonPhrase(), "Query Param must be 3 or more"));
		}

		return ResponseEntity.status(HttpStatus.METHOD_FAILURE)
				.body(new ResponseObject(HttpStatus.METHOD_FAILURE.getReasonPhrase(), "no Data"));
	}
	
	@PostMapping("med_search_response")
	public ResponseEntity<ResponseObject> saveSerachResponse(@RequestBody SearchResponseRequestVo searchResponseRequestVo) {  
		return null;
				
	}

}
