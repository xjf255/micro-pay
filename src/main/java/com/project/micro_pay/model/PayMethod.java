package com.project.micro_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paymethod")
public class PayMethod {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codMethod;

  private String name;

  private Boolean active;

  @OneToOne(mappedBy = "payMethod", cascade = CascadeType.ALL)
  @JsonIgnore
  private Pay pay;
}
