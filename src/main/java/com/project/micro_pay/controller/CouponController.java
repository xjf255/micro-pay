package com.project.micro_pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.micro_pay.model.Coupon;
import com.project.micro_pay.service.CouponService;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {
  @Autowired
  private CouponService couponService;

  @GetMapping
  public List<Coupon> getAllCoupons(){
    return couponService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Coupon> getCouponById(@PathVariable Long id){
    Coupon coupon = couponService.getCouponId(id);
    if (coupon == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(coupon);
  }

  @PostMapping
  public Coupon createCoupon(@RequestBody Coupon coupon){
    return couponService.saveCoupon(coupon);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Coupon> updateCouponById(@PathVariable Long id, @RequestBody Coupon dataCoupon){
    Coupon gCoupon = couponService.getCouponId(id);
    if(gCoupon == null) return ResponseEntity.notFound().build();
    gCoupon.setCod_coupon(dataCoupon.getCod_coupon());
    gCoupon.setExpiration_date(dataCoupon.getExpiration_date());
    gCoupon.setStatus(dataCoupon.getStatus());
    gCoupon.setValue(dataCoupon.getValue());
    Coupon updateCoupon = couponService.saveCoupon(gCoupon);
    return ResponseEntity.ok(updateCoupon);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCoupon(@PathVariable Long id){
    Coupon coupon = couponService.getCouponId(id);
    if(coupon == null){
      return ResponseEntity.notFound().build();
    }
    couponService.deleteCoupon(id);
    return ResponseEntity.noContent().build();
  }
}
