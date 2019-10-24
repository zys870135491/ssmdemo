package com.ssmdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public Map<String, Object> findEmpList(Integer pageNum,Integer pageSize,Employee emp) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();
        PageInfo<Employee> pageInfo = new PageInfo<>();
        try{
            PageHelper.startPage(pageNum,pageSize);
            empList = empMapper.findEmpList(emp);
            pageInfo = new PageInfo<>(empList);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",pageInfo);

        return resultMap;
    }

    @Override
    public Employee findEmpById(Integer empId) {
        Employee emp = empMapper.findEmpById(empId);
        return  emp;
    }

    @Override
    public Map<String,Object> updateEmp(Employee emp) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        try{
            empMapper.updateEmp(emp);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("修改失败");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        return resultMap;
    }

    @Override
    public Map<String, Object> addEmp(Employee emp) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        try {
            empMapper.addEmp(emp);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("添加失败");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        return resultMap;
    }

    @Override
    public Map<String, Object> deleteEmp(Integer empId) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        try {
            empMapper.deleteEmp(empId);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("删除失败");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        return resultMap;
    }

    @Override
    public List<Employee> findEmpListByExport(Employee emp) {
        return empMapper.findEmpList(emp);
    }
}
