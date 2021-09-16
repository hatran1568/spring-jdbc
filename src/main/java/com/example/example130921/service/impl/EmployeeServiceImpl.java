package com.example.example130921.service.impl;

import com.example.example130921.dao.entity.Employee;
import com.example.example130921.dao.repository.EmployeeRepository;
import com.example.example130921.service.AbstractService;
import com.example.example130921.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl extends AbstractService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.isPresent();
    }
}
