package com.lab3.lab3.repository;
import com.lab3.lab3.models.RequestHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RequestHistoryRepository extends CrudRepository<RequestHistory, Long> {
}