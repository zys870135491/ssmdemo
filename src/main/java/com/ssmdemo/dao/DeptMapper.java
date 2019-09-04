package com.ssmdemo.dao;

import com.ssmdemo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    List<Dept> findDeptList();

    List<Dept>  findDeptListConditions(Dept dept);

    List<Dept>  findDeptListChooseConditions(Dept dept);

    List<Dept>  findDeptListByIds(@Param("ids") List<Long> ids);

    boolean addDept(@Param("deptList") List<Dept> deptList);
}
