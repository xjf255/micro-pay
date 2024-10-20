package com.project.micro_pay.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pay")
public class Pay {
  // Hay que especificar el ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_pay;

  private Float amount;

  @OneToOne
  @JoinColumn(name = "id_coupon", nullable = true)
  private Coupon coupon;

  @OneToOne
  @JoinColumn(name = "cod_method", nullable = false)
  private PayMethod payMethod;

  @OneToOne
  @JoinColumn(name = "cod_tax", nullable = true)
  private Tax tax;

  @ManyToOne
  @JoinColumn(name = "id_status", nullable = false)
  private Status status;

  private Float total_amount;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate date_pay;

  @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<CouponUsed> couponUsed;

  @OneToOne(mappedBy = "idPay", cascade = CascadeType.ALL)
  @JsonIgnore
  private Bill bill;

  @PrePersist
  public void PrePersist() {
    if (date_pay == null) {
      date_pay = LocalDate.now();
    }
  }
}
