package com.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.model.MedSearchRequest;
@Repository
public interface MedSearchRequestRepository extends JpaRepository<MedSearchRequest, Long>{

}
