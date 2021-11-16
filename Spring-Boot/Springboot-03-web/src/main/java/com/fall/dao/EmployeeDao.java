package com.fall.dao;

import com.fall.pojo.Department;
import com.fall.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    // 模拟数据
    private static Map<Integer, Employee> employees = null;

    private final DepartmentDao departmentDao;
    public EmployeeDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001,"AA", "12354@163.com", 0, new Department(), new Date()));
        employees.put(1002, new Employee(1002,"AA", "12354@163.com", 0, new Department(), new Date()));
        employees.put(1003, new Employee(1003,"AA", "12354@163.com", 0, new Department(), new Date()));
        employees.put(1004, new Employee(1004,"AA", "12354@163.com", 0, new Department(), new Date()));
        employees.put(1005, new Employee(1005,"AA", "12354@163.com", 0, new Department(), new Date()));
    }

    private static Integer initID = 1003;

    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initID++);
        }
        employee.setDepartment(departmentDao.getDepartmentByID(employee.getId()));

        employees.put(employee.getId(), employee);
    }

    /**
     * 查询所有
     * @return
     */
    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeByID(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
