package com.ssmdemo.dao;

import com.ssmdemo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    List<Dept> findDeptList();
}
