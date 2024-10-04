package com.project.micro_pay.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

  @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
  private List<Coupon> coupon;

  @OneToOne
  @JoinColumn(name = "id_method", nullable = false)
  private PayMethod payMethod;

  @ManyToMany
  @JoinTable(name = "pay_tax", joinColumns = @JoinColumn(name = "id_pay"), inverseJoinColumns = @JoinColumn(name = "id_tax"))
  private List<Tax> tax;

  @OneToOne
  @JoinColumn(name = "id_status", nullable = false)
  private Status status;

  private Float total_amount;
  private Timestamp date_pay;

  @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<CouponUsed> couponUsed;

  @OneToOne(mappedBy = "pay", cascade = CascadeType.ALL)
  @JsonIgnore
  private Bill bill;
}
