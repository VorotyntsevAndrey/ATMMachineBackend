package com.samsung.itschool.repository;


import com.samsung.itschool.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
