package com.project.micro_pay.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pay {
  // Hay que especificar el ID
  @Id
  // Especifica como se generara el ID
  // pero en este caso como es incrementable
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pay;

  private Float amount;

  @OneToOne
  @JoinColumn(name = "pay", nullable = true)
  private Coupon coupon;

  @OneToOne
  @JoinColumn(name = "id_method", nullable = false)
  private PayMethod payMethod;

  @OneToOne
  @JoinColumn(name = "tax", nullable = true)
  private Tax tax;

  @OneToOne
  @JoinColumn(name = "id_status", nullable = false)
  private Status status;

  private Float total_amount;
  private LocalDate date_pay;

  @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<CouponUsed> couponUsed;

  @OneToOne(mappedBy = "pay", cascade = CascadeType.ALL)
  @JsonIgnore
  private Bill bill;
}
