package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.micro_pay.model.CouponUsed;
import com.project.micro_pay.repository.CouponUsedRepository;

public class CouponUsedService {
  @Autowired
  private CouponUsedRepository couponUsedRepository;

  public CouponUsed getCouponUsedById(Long id){
    return couponUsedRepository.findById(id).orElse(null);
  }

  public List<CouponUsed> GetAll(){
    return couponUsedRepository.findAll();
  }

  public CouponUsed saveCouponUsed(CouponUsed couponUsed){
    return couponUsedRepository.save(couponUsed);
  }

  public void deleteCouponUsed(Long id){
    couponUsedRepository.deleteById(id);
  }
}
