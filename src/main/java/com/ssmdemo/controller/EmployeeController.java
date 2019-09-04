package com.ssmdemo.controller;

import com.ssmdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/empController")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @RequestMapping(value = "/findEmpList")
    @ResponseBody
    public Map<String,Object> findEmpList(){
        return empService.findEmpList();
    }
}
