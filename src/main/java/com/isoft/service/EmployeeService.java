package com.isoft.service;

import com.isoft.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;
    public List<Map<String,Object>>findPost(){
        return employeeDAO.findPost();
    }
    public List<Map<String,Object>>findPostInfo(String name,int postid){
        return employeeDAO.findPostInfo(name,postid);
    }
}
