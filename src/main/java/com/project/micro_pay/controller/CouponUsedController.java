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

import com.project.micro_pay.model.CouponUsed;
import com.project.micro_pay.service.CouponUsedService;

@RestController
@RequestMapping("/api/CouponUsed")
public class CouponUsedController {
  
  @Autowired
  private CouponUsedService couponUsedService;

  @GetMapping
  public List<CouponUsed> getAllCouponUseds(){
    return couponUsedService.GetAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CouponUsed> getCouponUsedById(@PathVariable Long id){
    CouponUsed couponUsed = couponUsedService.getCouponUsedById(id);
    if(couponUsed == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(couponUsed);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CouponUsed> updateCouponUsed(@PathVariable Long id, @RequestBody CouponUsed dataCouponUsed){
    CouponUsed couponUsed = couponUsedService.getCouponUsedById(id);
    if (couponUsed == null) return ResponseEntity.notFound().build();
    couponUsed.setCoupon(dataCouponUsed.getCoupon());
    couponUsed.setDateCouponUsed(dataCouponUsed.getDateCouponUsed());
    couponUsed.setPay(dataCouponUsed.getPay());
    CouponUsed newCouponUsed = couponUsedService.saveCouponUsed(couponUsed);
    return ResponseEntity.ok(newCouponUsed);
  }

  @PostMapping
  public CouponUsed creatCouponUsed(@RequestBody CouponUsed dataCouponUsed){
    return couponUsedService.saveCouponUsed(dataCouponUsed);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCouponUsed(@PathVariable Long id){
    CouponUsed couponUsed = couponUsedService.getCouponUsedById(id);
    if(couponUsed == null) return ResponseEntity.notFound().build();
    couponUsedService.deleteCouponUsed(id);
    return ResponseEntity.noContent().build();
  }

}

