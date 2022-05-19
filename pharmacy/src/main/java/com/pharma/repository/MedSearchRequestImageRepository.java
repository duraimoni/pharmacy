package com.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.model.MedSearchRequestImage;
@Repository
public interface MedSearchRequestImageRepository extends JpaRepository<MedSearchRequestImage, Long> {

}
