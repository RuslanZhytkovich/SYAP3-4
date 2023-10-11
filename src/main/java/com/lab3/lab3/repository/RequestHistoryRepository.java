package com.lab3.lab3.repository;

import com.lab3.lab3.models.RequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long> {
    List<RequestHistory> findAll();
  
}