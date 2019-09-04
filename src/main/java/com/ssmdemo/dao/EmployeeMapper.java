package com.ssmdemo.dao;

import com.ssmdemo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> findEmpList();
}
