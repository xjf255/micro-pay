package com.project.micro_pay.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.micro_pay.model.Coupon;
import com.project.micro_pay.model.Pay;

import com.project.micro_pay.repository.PayRepository;

@Service
public class PayService {
  @Autowired
  private PayRepository payRepository;

  private void handleCoupon(Pay pay) {
    if (pay.getCoupon() != null && pay.getCoupon().getId_coupon() != null) {
      final Long statusCoupon = 5L;
      Coupon coupon = pay.getCoupon();
      payRepository.changeStatus(coupon.getId_coupon(), statusCoupon);
      LocalDateTime now = LocalDateTime.now();
      payRepository.insertCouponUsed(pay.getId_pay(), coupon.getId_coupon(), now);
    }
  }

  public Pay savePay(Pay pay) {
    try {
      if (pay.getCoupon() != null && pay.getCoupon().getId_coupon() != null) {
        if (!pay.getCoupon().getExpiration_date().isAfter(LocalDate.now())) {
          throw new IllegalArgumentException("Expiration Date not valid");
        }
      }
      return payRepository.save(pay);
    } catch (Exception e) {
      throw new RuntimeException("Error saving pay: " + e.getMessage(), e);
    }
  }

  @Transactional
  public void transferPay(Pay pay, Integer idPedido) {
    try {
      Pay successPay = savePay(pay);  
      System.out.println(successPay);
      payRepository.insertBill(successPay.getId_pay(), idPedido);
      handleCoupon(successPay);
    } catch (DataAccessException dae) {
      throw new RuntimeException("Error de base de datos al realizar la transaccion de pago " + dae.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error inesperado " + e.getMessage());
    }
  }

  public Pay getPayById(Long id) {
    return payRepository.findById(id).orElse(null);
  }

  public List<Pay> getAll() {
    return payRepository.findAll();
  }

  public void deletePay(Long id) {
    payRepository.deleteById(id);
  }
}
