package com.example.demo.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Operations;
import com.example.demo.repository.OperationRepository;

@Service
public class OperationService {

    @Autowired
    private OperationRepository repository;

    public List<Operations> getAllOperations() {
        return repository.findAll();
    }

    public void saveOperation(Operations operation) {
        repository.save(operation);
    }

    public Operations getOperationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteOperation(Long id) {
        repository.deleteById(id);
    }
}
