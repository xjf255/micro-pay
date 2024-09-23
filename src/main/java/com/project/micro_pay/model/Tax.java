package com.project.micro_pay.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Tax {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codTax;
  
  private String name;
  private Float percentage;

  @ManyToMany(mappedBy = "tax",cascade = CascadeType.PERSIST)
  @JsonIgnore
  private List<Pay> pay;
}
