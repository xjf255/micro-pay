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

import com.project.micro_pay.model.Tax;
import com.project.micro_pay.service.TaxService;

//se utiliza para crear controladores que gestionen las solicitudes HTTP (GET, POST, PUT, DELETE
@RestController
//Define una URL base para todas las rutas que el controlador maneje
@RequestMapping("/api/tax")
public class TaxController {

  @Autowired
  private TaxService taxService;

  @GetMapping
  public List<Tax> getAllTax(){
    return taxService.GetAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Tax> getTaxById(@PathVariable Long id){
    Tax tax = taxService.GetTaxById(id);
    return tax != null ? ResponseEntity.ok(tax): ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Tax> updateTaxById(@PathVariable Long id,@RequestBody Tax dataTax ){
    //obtengo el registro
    Tax tax = taxService.GetTaxById(id);
    if( tax == null){
      return ResponseEntity.notFound().build();
    }
    //seteo los datos en el registro
    tax.setName(dataTax.getName());
    tax.setPay(dataTax.getPay());
    tax.setPercentage(dataTax.getPercentage());
    //Guardo el registro
    Tax UpdateTax = taxService.saveTax(tax);
    return ResponseEntity.ok(UpdateTax);
  }

  @PostMapping
  public Tax createTax(@RequestBody Tax tax){
    return taxService.saveTax(tax);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTax(@PathVariable Long id){
    Tax tax = taxService.GetTaxById(id);
    if(tax == null){
      return ResponseEntity.notFound().build();
    }
    taxService.deleteTax(id);
    return ResponseEntity.noContent().build();
  }
}
