package com.project.micro_pay.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coupon")
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_coupon;

  private String cod_coupon;

  private Float value;

  private LocalDate expiration_date;

  @ManyToOne
  @JoinColumn(name = "id_status", nullable = false)
  private Status status;

  @OneToOne(mappedBy = "coupon", cascade = CascadeType.PERSIST)
  @JsonIgnore
  private Pay pay;

  @OneToOne(mappedBy = "coupon", cascade = CascadeType.ALL)
  @JsonIgnore
  private CouponUsed couponUsed;
}
