package com.project.micro_pay.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "couponused")
public class CouponUsed {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codCouponUsed;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDateTime dateCouponUsed;

  @ManyToOne
  @JoinColumn(name = "id_pay", nullable = false)
  private Pay pay;

  @OneToOne
  @JoinColumn(name = "coupon", nullable = false)
  private Coupon coupon;
}
