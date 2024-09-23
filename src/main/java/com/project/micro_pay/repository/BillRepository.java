package com.project.micro_pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.micro_pay.model.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
