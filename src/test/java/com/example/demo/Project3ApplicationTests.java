package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Operations;
import com.example.demo.repository.OperationRepository;
import com.example.demo.service.OperationService;



@SpringBootTest
class Project3ApplicationTests {
	
	@Autowired
	private OperationService service;
	
	@MockBean
	private OperationRepository opeRepo;
	
	
	@Test
	public void getAllOperationsTest() {
		when(opeRepo.findAll()).thenReturn(Stream.
				of(new Operations(1,"Shankar","s@gmail.com","Eviden", "500000"), new Operations(2, "Siva","h@gmail.com", "Eviden", "400000")).collect(Collectors.toList()));
		
		assertEquals(2, service.getAllOperations().size());
	}
	
}
