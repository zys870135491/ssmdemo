package com.ssmdemo.service;

import com.ssmdemo.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    Map<String,Object> findDeptList();

    Map<String,Object> findDeptListConditions(Dept dept);

    Map<String,Object> findDeptListChooseConditions(Dept dept);

    Map<String,Object> findDeptListByIds(List<Long> ids);

    Map<String,Object> addDept(List<Dept> deptList);
}
