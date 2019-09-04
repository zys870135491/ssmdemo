package com.ssmdemo.service.impl;

import com.ssmdemo.dao.EmployeeMapper;
import com.ssmdemo.entity.Employee;
import com.ssmdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper empMapper;

    @Override
    public Map<String, Object> findEmpList() {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();
        try{
            empList = empMapper.findEmpList();
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",empList);

        return resultMap;
    }
}
