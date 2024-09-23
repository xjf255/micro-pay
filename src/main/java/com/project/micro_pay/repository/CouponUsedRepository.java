package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.CouponUsed;

public interface CouponUsedRepository extends JpaRepository<CouponUsed,Long> {
  
}
