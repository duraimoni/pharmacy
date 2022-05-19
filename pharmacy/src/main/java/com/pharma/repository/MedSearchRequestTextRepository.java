package com.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.model.MedSearchRequestText;
@Repository
public interface MedSearchRequestTextRepository extends JpaRepository<MedSearchRequestText, Long> {

}
