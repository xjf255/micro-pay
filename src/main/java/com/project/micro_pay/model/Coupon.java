package com.project.micro_pay.model;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Coupon {
  @Id
  @GeneratedValue
  private Long id_coupon;
  
  private String cod_coupon;
  private Float value;
  private Timestamp expiration_date;

  @OneToOne
  @JoinColumn(name = "id_status", nullable = false)
  private Status status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JsonIgnore
  private Pay pay;

  @OneToOne(mappedBy = "coupon", cascade = CascadeType.ALL)
  @JsonIgnore
  private CouponUsed couponUsed;
}
