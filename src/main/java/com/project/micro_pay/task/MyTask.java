package com.project.micro_pay.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class MyTask {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Scheduled(cron = "0 0 0 * * ?")  
  public void updateStateCoupon(){
    LocalDate day = LocalDate.now(); 
    final Long idStatusExpiration = 6L;
    final Long idStatusAvailable = 4L;
    String query = "update coupon set id_status = ? where coupon.expiration_date <= ? and coupon.id_status = ?";
    int rowAffected = jdbcTemplate.update(query, idStatusExpiration,day, idStatusAvailable);
    if(rowAffected != 0 ) System.out.println("Coupones actualizados " + rowAffected);
  }
}
