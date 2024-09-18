package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(int theId);
    void save(Department theDepartment);
    void deleteById(int theId);
}
