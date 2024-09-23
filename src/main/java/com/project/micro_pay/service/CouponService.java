package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.Coupon;
import com.project.micro_pay.repository.CouponRepository;

@Service
public class CouponService {
  @Autowired
  private CouponRepository couponRepository;

  public Coupon getCouponId( Long id){
    return couponRepository.findById(id).orElse(null);
  }

  public List<Coupon> getAll(){
    return couponRepository.findAll();
  }

  public Coupon saveCoupon(Coupon coupon){
    return couponRepository.save(coupon);
  }

  public void deleteCoupon(Long id){
    couponRepository.deleteById(id);
  }
}
