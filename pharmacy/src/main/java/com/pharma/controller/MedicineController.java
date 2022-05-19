package com.pharma.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.model.Medicine;
import com.pharma.service.PharmacyService;
import com.pharma.vo.ResponseObject;

@RestController
@RequestMapping("medicines")
@Validated
public class MedicineController {
	@Autowired
	private PharmacyService pharmacyService;

	@GetMapping("")
	public ResponseEntity<ResponseObject> getMedicines(@RequestParam("q") String medicineName ) { // @Size(min = 3,
																									// message =
																									// "{validation.name.size.too_short}")
		if (medicineName.length() < 3) {
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body(
					new ResponseObject(HttpStatus.METHOD_FAILURE.getReasonPhrase(), "Query Param must be 3 or more"));
		}
		Optional<List<Medicine>> medicineList = pharmacyService.getMedicines(medicineName);
		if (!medicineList.get().isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject(HttpStatus.OK.getReasonPhrase(), medicineList.get()));
		} else {
			return ResponseEntity.status(HttpStatus.METHOD_FAILURE)
					.body(new ResponseObject(HttpStatus.METHOD_FAILURE.getReasonPhrase(), "no Data"));
		}
	}
}
