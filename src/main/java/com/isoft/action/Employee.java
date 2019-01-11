package com.isoft.action;

import com.alibaba.fastjson.JSON;
import com.isoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class Employee {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/findAllPost.do",produces = "text/html;charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public String findPost(){
        List<Map<String, Object>> post = employeeService.findPost();
        String jsonStr= JSON.toJSONString(post);
        return jsonStr;
    }
    @RequestMapping(value = "/findPostInfo.do",produces = "text/html;charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public String findPostInfo(String name,int postid){
        List<Map<String, Object>> postInfo = employeeService.findPostInfo(name, postid);
        String jStr= JSON.toJSONString(postInfo);
        return jStr;
    }
}
