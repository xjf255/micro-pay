package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.PayMethod;

public interface PayMethodRepository extends JpaRepository<PayMethod,Long> {
  
}
