package com.example.CollegeDetails.repository;



import com.example.CollegeDetails.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
    List<Faculty> findByCollegeName(String collegeName);

    List<Faculty> findByDepartmentName(String departmentName);
}