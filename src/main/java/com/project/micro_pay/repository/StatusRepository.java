package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.Status;

public interface StatusRepository extends JpaRepository<Status,Long>{
  
}
