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

import com.project.micro_pay.model.PayMethod;
import com.project.micro_pay.service.PayMethodService;

@RestController
@RequestMapping("/api/payMethod")
public class PayMethodController {

  @Autowired
  private PayMethodService payMethodService;

  @GetMapping
  public List<PayMethod> getAllPayMethods() {
    return payMethodService.getAllPayMethods();
  }

  @GetMapping("/{id}")
  public ResponseEntity<PayMethod> getPayMethorById(@PathVariable Long id){
    PayMethod payMethod = payMethodService.getPayMethodId(id);
    if(payMethod == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(payMethod);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PayMethod> updatePayMethor(@PathVariable Long id, @RequestBody PayMethod dataPayMethod){
    PayMethod gPayMethod = payMethodService.getPayMethodId(id);
    if(gPayMethod == null) return ResponseEntity.notFound().build();
    gPayMethod.setActive(dataPayMethod.getActive());
    gPayMethod.setName(dataPayMethod.getName());
    gPayMethod.setPay(dataPayMethod.getPay());
    gPayMethod.setUpdate_date(dataPayMethod.getUpdate_date());
    PayMethod newPayMethod = payMethodService.savePayMethod(gPayMethod);
    return ResponseEntity.ok(newPayMethod);
  }

  @PostMapping
  public PayMethod createPayMethod(@RequestBody PayMethod dataPayMethod){
    return payMethodService.savePayMethod(dataPayMethod);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePayMethod(@PathVariable Long id){
    PayMethod payMethod = payMethodService.getPayMethodId(id);
    if(payMethod == null) return ResponseEntity.notFound().build();
    payMethodService.deletePayMethod(id);
    return ResponseEntity.noContent().build();
  }
}
