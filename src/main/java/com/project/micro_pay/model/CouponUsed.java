package com.project.micro_pay.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CouponUsed {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codCouponUsed;

  private Timestamp dateCouponUsed;

  @ManyToOne
  @JoinColumn(name = "id_pay", nullable = false)
  private Pay pay;

  @OneToOne
  @JoinColumn(name = "id_coupon", nullable = false)
  private Coupon coupon;
}