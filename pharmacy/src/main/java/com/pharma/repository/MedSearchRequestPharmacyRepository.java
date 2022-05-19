package com.pharma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharma.model.MedSearchRequestPharmacy;

@Repository
public interface MedSearchRequestPharmacyRepository extends JpaRepository<MedSearchRequestPharmacy, Long> {
	
	@Query("select a from MedSearchRequestPharmacy a "
			+ " join a.medSearchRequest req"
			+ " join  req.medSearchRequestTexts mt "
			+ " join mt.medicine med"
			+ " where med.medicineName LIKE CONCAT('%',:medicineName,'%') ")
	public List<MedSearchRequestPharmacy> findByMedicineName(@Param(value = "medicineName") String medicineName);
}
