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

import com.project.micro_pay.model.Pay;
import com.project.micro_pay.service.PayService;

@RestController
@RequestMapping("/api/pay")
public class PayController {
  @Autowired
  private PayService payService;

  @GetMapping
  public List<Pay> getAllPays() {
    return payService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pay> getPayById(@PathVariable Long id) {
    Pay pay = payService.getPayById(id);
    if (pay == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pay);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pay> updatePayById(@PathVariable Long id, @RequestBody Pay dataPay) {
    Pay pay = payService.getPayById(id);
    if (pay == null)
      return ResponseEntity.notFound().build();
    pay.setAmount(dataPay.getAmount());
    pay.setBill(dataPay.getBill());
    pay.setCoupon(dataPay.getCoupon());
    pay.setCouponUsed(dataPay.getCouponUsed());
    pay.setDate_pay(dataPay.getDate_pay());
    pay.setPayMethod(dataPay.getPayMethod());
    pay.setStatus(dataPay.getStatus());
    pay.setTax(dataPay.getTax());
    pay.setTotal_amount(dataPay.getTotal_amount());
    Pay newPay = payService.savePay(pay);
    return ResponseEntity.ok(newPay);
  }

  @PostMapping()
  public Pay createPay(@RequestBody Pay pay) {
    return payService.savePay(pay);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePay(@PathVariable Long id) {
    Pay pay = payService.getPayById(id);
    if (pay == null)
      return ResponseEntity.notFound().build();
    payService.deletePay(id);
    return ResponseEntity.noContent().build();
  }
}
