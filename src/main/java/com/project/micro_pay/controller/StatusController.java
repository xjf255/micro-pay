package com.project.micro_pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.micro_pay.model.Status;
import com.project.micro_pay.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {
  
  @Autowired
  private StatusService statusService;

  @GetMapping
  public List<Status> getAllStatus(){
    return statusService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Status> getStatusById(@PathVariable Long id){
    Status status = statusService.getStatusId(id);
    if(status == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(status);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Status> updateStatusById(@PathVariable Long id, @RequestBody Status bodyStatus){
    Status status = statusService.getStatusId(id);
    if(status == null) return ResponseEntity.notFound().build();
    status.setName_status(bodyStatus.getName_status());
    status.setCoupon(bodyStatus.getCoupon());
    status.setPay(bodyStatus.getPay());
    Status updateStatus = statusService.saveStatus(status);
    return ResponseEntity.ok(updateStatus);
  }

  @PostMapping
  public Status createStatus(@RequestBody Status bodyStatus){
    return statusService.saveStatus(bodyStatus);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStatus(@PathVariable Long id){
    Status status = statusService.getStatusId(id);
    if(status == null){
      return ResponseEntity.notFound().build();
    }
    statusService.deleteStatus(id);
    return ResponseEntity.noContent().build();
  }
}
