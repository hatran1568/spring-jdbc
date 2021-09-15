package com.example.example130921.service.impl;

import com.example.example130921.dao.repository.EmployeeRepository;
import com.example.example130921.service.AbstractService;
import com.example.example130921.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends AbstractService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(int employeeId) {
        if (employeeRepository.getIdList().isPresent()){
            return employeeRepository.getIdList().get().contains(employeeId);
        }
        return false;

    }
}
