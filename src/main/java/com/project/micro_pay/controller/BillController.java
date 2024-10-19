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

import com.project.micro_pay.model.Bill;
import com.project.micro_pay.service.BillService;

@RestController
@RequestMapping("api/bill")
public class BillController {

  @Autowired
  private BillService billService;

  @GetMapping
  public List<Bill> getAllBill(){
    return billService.getAllBill();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Bill> getBillById(@PathVariable Long id){
    Bill bill = billService.getBillId(id);
    if(bill == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(bill);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill dataBill){
    Bill bill = billService.getBillId(id);
    if(bill == null) return ResponseEntity.notFound().build();
    bill.setIdPay(dataBill.getIdPay());
    bill.setIdPedido(dataBill.getIdPedido());
    Bill newBill = billService.saveBill(bill);
    return ResponseEntity.ok(newBill);
  }

  @PostMapping
  public Bill createBill(@RequestBody Bill dataBill){
    return billService.saveBill(dataBill);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBill(@PathVariable Long id){
    Bill bill = billService.getBillId(id);
    if(bill == null) return ResponseEntity.notFound().build();
    billService.deleteBill(id);
    return ResponseEntity.noContent().build();
  }
}
