package com.project.micro_pay.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  @OneToMany(mappedBy = "payMethod", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Pay> pay;
}
