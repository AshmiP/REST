package com.yash.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.yash.demo.exception.EmptyFieldException;
import com.yash.demo.exception.RecordNotFoundException;
import com.yash.demo.model.Employee;
import com.yash.demo.repository.EmployeeRepository;

@Service
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*to save an employee*/
	
	public Employee save(Employee emp) {
		
		
		return employeeRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Employee findOne(Long empid) {
		
		Optional<Employee> emp = employeeRepository.findById(empid);
		if(emp.isPresent()) {
			return emp.get();
		}
		else
		  throw new RecordNotFoundException("Invalid employee id :"+empid+" RECORD NOT FOUND....");
		
     }
	
	
	/*delete an employee*/
	
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}


}
