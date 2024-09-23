package com.project.micro_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Status {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cod_status;
  
  private String name_status;

  @OneToOne(mappedBy = "status", cascade = CascadeType.ALL)
  @JsonIgnore
  private Pay pay;

  @OneToOne(mappedBy = "status", cascade = CascadeType.ALL)
  @JsonIgnore
  private Coupon coupon;
}
