package com.example.CollegeDetails.Service;


import com.example.CollegeDetails.model.Department;
import com.example.CollegeDetails.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;
    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return repo.findByCollegeName(collegeName);
    }
    public Department addDepartment(Department department) {
        return repo.save(department);
    }
    public String getHodNameByDepartmentId(int departmentId) {
        Department department = repo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return department.getHodName();
    } }