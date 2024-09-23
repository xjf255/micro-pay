package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.PayMethod;
import com.project.micro_pay.repository.PayMethodRepository;

@Service
public class PayMethodService {
  @Autowired
  private PayMethodRepository payMethodRepository;

  public PayMethod getPayMethodId(Long id){
    return payMethodRepository.findById(id).orElse(null);
  }

  public List<PayMethod> getAllPayMethods(){
    return payMethodRepository.findAll();
  }

  public PayMethod savePayMethod( PayMethod payMethod){
    return payMethodRepository.save(payMethod);
  }

  public void deletePayMethod(Long id){
    payMethodRepository.deleteById(id);
  }
}
