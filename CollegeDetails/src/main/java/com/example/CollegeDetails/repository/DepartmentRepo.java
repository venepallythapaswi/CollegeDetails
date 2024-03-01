package com.example.CollegeDetails.repository;

import com.example.CollegeDetails.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    List<Department> findByCollegeName(String collegeName);

    //Optional<Department> findByName(String name);
}
