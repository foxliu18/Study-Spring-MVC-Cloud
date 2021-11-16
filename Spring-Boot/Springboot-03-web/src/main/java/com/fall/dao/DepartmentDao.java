package com.fall.dao;

import com.fall.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    // 模拟初始化
    private static Map<Integer, Department> departmentMap = null;
    static{
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "教学部"));
        departmentMap.put(103, new Department(103, "教学部"));
        departmentMap.put(104, new Department(104, "教学部"));
        departmentMap.put(105, new Department(105, "教学部"));


    }

    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }

    public Department getDepartmentByID(Integer id){
        return departmentMap.get(id);
    }
}
