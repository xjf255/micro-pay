package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.Tax;
import com.project.micro_pay.repository.TaxRepository;

@Service
public class TaxService {
  @Autowired
  private TaxRepository taxRepository;

  public Tax GetTaxById(Long id){
    return taxRepository.findById(id).orElse(null);
  }

  public List<Tax> GetAll(){
    return taxRepository.findAll();
  }

  public Tax saveTax(Tax tax){
    return taxRepository.save(tax);
  }

  public void deleteTax(Long id){
    taxRepository.deleteById(id);
  }
}
