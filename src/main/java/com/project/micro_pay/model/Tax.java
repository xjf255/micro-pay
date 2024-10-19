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
@Table(name = "tax")
public class Tax {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codTax;
  
  private String name;
  private Float percentage;

  @OneToOne(mappedBy = "tax",cascade = CascadeType.PERSIST)
  @JsonIgnore
  private Pay pay;
}
