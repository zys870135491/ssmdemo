package com.ssmdemo.service.impl;

import com.ssmdemo.dao.DeptMapper;
import com.ssmdemo.entity.Dept;
import com.ssmdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Map<String,Object> findDeptList(){
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Dept> deptList = new ArrayList<>();
        try{
            deptList = deptMapper.findDeptList();
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",deptList);

        return resultMap;
    }

    @Override
    public Map<String, Object> findDeptListConditions(Dept dept) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Dept> deptList = new ArrayList<>();
        try{
            deptList = deptMapper.findDeptListConditions(dept);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",deptList);

        return resultMap;
    }

    @Override
    public Map<String, Object> findDeptListChooseConditions(Dept dept) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Dept> deptList = new ArrayList<>();
        try{
            deptList = deptMapper.findDeptListChooseConditions(dept);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",deptList);

        return resultMap;
    }

    @Override
    public Map<String, Object> findDeptListByIds(List<Long> ids) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();
        List<Dept> deptList = new ArrayList<>();
        try{
            deptList = deptMapper.findDeptListByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("查询错误");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);
        resultMap.put("records",deptList);

        return resultMap;
    }

    @Override
    public Map<String, Object> addDept(List<Dept> deptList) {
        Map<String,Object> resultMap = new HashMap<>();
        List<String> errorList = new ArrayList<>();

        try{
            deptMapper.addDept(deptList);
        }catch (Exception e){
            e.printStackTrace();
            errorList.add("添加失败");
        }
        resultMap.put("success",errorList.size()>0?false:true);
        resultMap.put("message",errorList);

        return resultMap;
    }


}
