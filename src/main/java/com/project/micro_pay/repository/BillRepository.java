package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import com.project.micro_pay.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
  // cambiar estado de coupon si es ingresado
  @Transactional
  @Modifying
  @Query(value = "update coupon set id_status = :id_status where id_coupon =:coupon", nativeQuery = true)
  void changeStatus(@Param("coupon") Long coupon, @Param("id_status") Long id_status);

  // ingresar el coupon a couponused
  @Transactional
  @Modifying
  @Query(value = "insert into couponused(date_coupon_used,coupon,id_pay) values(:date_coupon_used,:coupon,:id_pay)", nativeQuery = true)
  void insertCouponUsed(@Param("id_pay") Long id_pay, @Param("coupon") Long coupon,
      @Param("date_coupon_used") LocalDateTime date_coupon_used);
}
