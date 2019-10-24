package com.ssmdemo.service;

import com.ssmdemo.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Map<String,Object> findEmpList(Integer pageNum, Integer pageSize, Employee emp);

    Employee findEmpById(Integer empId);

    Map<String,Object> updateEmp(Employee emp);

    Map<String,Object> addEmp(Employee emp);

    Map<String,Object> deleteEmp(Integer empId);

    List<Employee> findEmpListByExport(Employee emp);
}
