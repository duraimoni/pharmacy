package com.pharma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharma.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	@Query("select a from Medicine a where a.medicineName LIKE CONCAT('%',:medicineName,'%') ORDER BY a.medicineName DESC ")
	public List<Medicine> findByMedicineName(@Param(value = "medicineName") String medicineName);

}
