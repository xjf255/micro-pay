package com.project.micro_pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.micro_pay.model.Status;
import com.project.micro_pay.repository.StatusRepository;

@Service
public class StatusService {
   @Autowired
   private StatusRepository statusRepository;

   public List<Status> getAll(){
      return statusRepository.findAll();
   }

   public Status getStatusId(Long id){
      return statusRepository.findById(id).orElse(null);
   }

   public Status saveStatus(Status status){
      return statusRepository.save(status);
   }

   public void deleteStatus(Long id){
      statusRepository.deleteById(id);
   }
}
