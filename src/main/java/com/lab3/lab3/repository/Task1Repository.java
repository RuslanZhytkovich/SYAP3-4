package com.lab3.lab3.repository;

import com.lab3.lab3.models.Task1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Task1Repository extends JpaRepository<Task1, Long> {
    Task1 findByUniqueValue(String uniqueValue);
}
