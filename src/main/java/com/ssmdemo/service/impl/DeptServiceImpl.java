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


}
