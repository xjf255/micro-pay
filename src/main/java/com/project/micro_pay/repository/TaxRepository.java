package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.Tax;

public interface TaxRepository extends JpaRepository<Tax,Long>{
  
}
