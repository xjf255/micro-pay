package com.project.micro_pay.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


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

  @OneToMany(mappedBy = "tax",cascade = CascadeType.PERSIST)
  @JsonIgnore
  private List<Pay> pay;
}
