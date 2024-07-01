package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Operations;

public interface OperationRepository extends JpaRepository<Operations, Long> {

}
