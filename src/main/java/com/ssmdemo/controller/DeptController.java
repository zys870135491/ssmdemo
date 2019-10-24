package com.ssmdemo.controller;

import com.ssmdemo.entity.Dept;
import com.ssmdemo.service.DeptService;
import com.ssmdemo.service.impl.DeptServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/deptController")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/visit")
    public String toLogin(){
        System.out.println("login..............");
        return "login";
    }

    @RequestMapping(value = "/toDeptList")
    public String toDeptList(){
        System.out.println("index..............");
        return "index";
    }

    @RequestMapping(value = "/findDeptList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> finDeptList(){
        return deptService.findDeptList();
    }

    @RequestMapping(value = "/findDeptListConditions")
    @ResponseBody
    public Map<String,Object> findDeptListConditions(){
        Dept dept = new Dept();
        dept.setId(1002);
        dept.setDeptName("销售部");
        return deptService.findDeptListConditions(dept);
    }

    @RequestMapping(value = "/findDeptListChooseConditions")
    @ResponseBody
    public Map<String,Object> findDeptListChooseConditions(){
        Dept dept = new Dept();
        //dept.setId(1005);
        //dept.setDeptName("销售部");
        return deptService.findDeptListChooseConditions(dept);
    }

    @RequestMapping(value = "/findDeptListByIds")
    @ResponseBody
    public Map<String,Object> findDeptListByIds(){
        List<Long> ids = new ArrayList(Arrays.asList(1002,1005)
        );
        return deptService.findDeptListByIds(ids);
    }

    @RequestMapping(value = "/addDept")
    @ResponseBody
    public Map<String,Object> addDept(){
        Dept dept =  new Dept();
        dept.setDeptName("礼仪部");
        Dept dept1 =  new Dept();
        dept1.setDeptName("公关部");
        List<Dept> deptList = new ArrayList(Arrays.asList(
                dept,dept1
        ));
        Map<String, Object> resultMap = deptService.addDept(deptList);
        System.out.println("deptId------------>"+dept.getId());
        System.out.println("dept1Id------------>"+dept1.getId());
        return resultMap;
    }


}
