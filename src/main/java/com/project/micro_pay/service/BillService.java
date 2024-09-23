package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.Bill;
import com.project.micro_pay.repository.BillRepository;

@Service
public class BillService {
  @Autowired
  private BillRepository billRepository;

  public List<Bill> getAllBill(){
    return billRepository.findAll();
  }

  public Bill getBillId(Long id){
    return billRepository.findById(id).orElse(null);
  }

  public void deleteBill(Long id){
    billRepository.deleteById(id); 
  }

  public Bill saveBill(Bill bill){
    return billRepository.save(bill);
  }
}
