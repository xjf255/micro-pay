package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import com.project.micro_pay.model.Pay;

public interface PayRepository extends JpaRepository<Pay, Long> {

  // crear factura
  @Modifying
  @Transactional
  @Query(value = "INSERT INTO schemagrupo5.bill (id_pay, id_pedido) VALUES (:id_pay, :id_pedido)", nativeQuery = true)
  void insertBill(@Param("id_pay") Long id_pay, @Param("id_pedido") Integer id_pedido);

  // cambiar estado de coupon si es ingresado
  @Transactional
  @Modifying
  @Query(value = "update schemagrupo5.coupon set id_status = :id_status where id_coupon =:coupon", nativeQuery = true)
  void changeStatus(@Param("coupon") Long coupon, @Param("id_status") Long id_status);

  // ingresar el coupon a couponused
  @Transactional
  @Modifying
  @Query(value = "insert into schemagrupo5.couponused(date_coupon_used,coupon,id_pay) values(:date_coupon_used,:coupon,:id_pay)", nativeQuery = true)
  void insertCouponUsed(@Param("id_pay") Long id_pay, @Param("coupon") Long coupon,
      @Param("date_coupon_used") LocalDateTime date_coupon_used);
}
