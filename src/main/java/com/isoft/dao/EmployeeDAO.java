package com.isoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>>findPost(){
        String sql="select * from post";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    public List<Map<String, Object>> findPostInfo(String name,int postid){
        String sql="select a.id,b.post_name,emp_name,CASE emp_sex WHEN 1 THEN \"男\" WHEN 2 THEN \"女\" ELSE \"-\" END as emp_sex,emp_age,emp_depart,emp_year from employee a INNER JOIN post b on a.post_type=b.id WHERE emp_name=? and post_type=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,new String[]{name,String.valueOf(postid)});
        return maps;
    }
}
