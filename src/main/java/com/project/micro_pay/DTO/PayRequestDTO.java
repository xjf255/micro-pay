package com.project.micro_pay.DTO;

import com.project.micro_pay.model.Pay;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayRequestDTO {
  private Pay pay;
  private Integer idPedido;
}
