package com.ssmdemo.dao;

import com.ssmdemo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> findEmpList(Employee emp);

    Employee findEmpById(@Param("empId") Integer empId);

    void updateEmp(Employee emp);

    void addEmp(Employee emp);

    void deleteEmp(@Param("empId") Integer empId);

}
