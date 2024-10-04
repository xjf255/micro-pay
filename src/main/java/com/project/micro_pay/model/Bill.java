package com.project.micro_pay.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bill {
  @Id
  @GeneratedValue
  private Long cod_bill;

  @OneToOne
  @JoinColumn(name = "id_pay", nullable = false)
  private Pay pay;

  private Integer idPedido;
}
