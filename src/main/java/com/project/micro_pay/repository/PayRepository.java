package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.Pay;

public interface PayRepository extends JpaRepository<Pay,Long>{
  
  // @Modifying
  // @Query("inset")

}
