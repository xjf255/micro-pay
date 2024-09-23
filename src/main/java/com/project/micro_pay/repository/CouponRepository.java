package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
  
}
