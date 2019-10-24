package com.ssmdemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssmdemo.entity.Employee;
import com.ssmdemo.service.EmployeeService;
import com.ssmdemo.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/empController")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

/*    @RequestMapping(value = "/findEmpList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findEmpList(Integer pageNum,Integer pageSize,String lastName ){

        return empService.findEmpList(pageNum,pageSize,lastName);
    }*/

    @RequestMapping(value = "/findEmpList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> findEmpList(@RequestBody String jsonDate ){
        Employee employee = new Employee();
        JSONObject object = JSONObject.parseObject(jsonDate);
        Integer pageNum = Integer.valueOf(object.getString("pageNum"));
        Integer pageSize = Integer.valueOf(object.getString("pageSize"));
        JSONObject searchObject = object.getJSONObject("search");
        if(searchObject!=null){
           employee = searchObject.toJavaObject(Employee.class);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return empService.findEmpList(pageNum,pageSize,employee);
    }

    @RequestMapping(value = "findEmpById" , method = RequestMethod.GET)
    @ResponseBody
    public Employee findEmpById(Integer empId){
        return empService.findEmpById(empId);
    }

    @RequestMapping(value = "updateEmp" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateEmp(@RequestBody String empForm){
        JSONObject object = JSONObject.parseObject(empForm);
        Employee employee = object.toJavaObject(Employee.class);
        return empService.updateEmp(employee);
    }

    @RequestMapping(value = "addEmp" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addEmp(@RequestBody String empForm){
        JSONObject object = JSONObject.parseObject(empForm);
        Employee employee = object.toJavaObject(Employee.class);
        return empService.addEmp(employee);
    }

    @RequestMapping(value = "deleteEmp" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> deleteEmp(Integer empId){
        return empService.deleteEmp(empId);
    }

    @RequestMapping(value ="export", method = RequestMethod.GET)
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Employee employee = new Employee();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取数据
        List<Employee> empList = empService.findEmpListByExport( employee);

        //excel标题
        String[] title = {"用户Id", "用户名", "用户性别", "用户邮箱", "用户部门名称"};

        //excel文件名
        String fileName = "用户表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "用户信息表";

        String content[][] = new String[empList.size()][title.length];
        for (int i = 0; i < empList.size(); i++) {


            Employee emp = empList.get(i);
            content[i][0] = emp.getId().toString();
            content[i][1] = emp.getLastName();
            content[i][2] = emp.getGender().toString();
            content[i][3] = emp.getEmail();
            content[i][4] = emp.getDept().getDeptName();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        //响应到客户端
        try {
            ExcelUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
