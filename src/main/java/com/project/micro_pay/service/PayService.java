package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.Pay;
import com.project.micro_pay.repository.PayRepository;

@Service
public class PayService {
  @Autowired
  private PayRepository payRepository;

  public Pay getPayById(Long id){
    return payRepository.findById(id).orElse(null);
  }

  public List<Pay> getAll(){
    return payRepository.findAll();
  }

  public Pay savePay(Pay pay){
    return payRepository.save(pay);
  }

  public void deletePay(Long id){
    payRepository.deleteById(id);
  }
}
