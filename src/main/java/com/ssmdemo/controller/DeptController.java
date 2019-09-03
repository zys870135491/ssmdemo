package com.ssmdemo.controller;

import com.ssmdemo.service.DeptService;
import com.ssmdemo.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/deptController")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/visit")
    public String toLogin(){
        System.out.println("visit..............");
        return "login";
    }

    @RequestMapping(value = "/findEmpList")
    @ResponseBody
    public Map<String,Object> finEmpList(){
        return deptService.findDeptList();
    }


}
