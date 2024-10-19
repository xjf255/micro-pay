package com.project.micro_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
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

  private String entity;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Pay> pay;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Coupon> coupon;
}
