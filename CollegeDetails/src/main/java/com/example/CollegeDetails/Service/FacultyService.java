package com.example.CollegeDetails.Service;


import com.example.CollegeDetails.model.Department;
import com.example.CollegeDetails.model.Faculty;
import com.example.CollegeDetails.repository.DepartmentRepo;
import com.example.CollegeDetails.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private DepartmentRepo drepo;
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }
    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        return facultyRepo.findByCollegeName(collegeName);
    }
    public Faculty assignFacultyToDepartment(int facultyId, int departmentId) {
        Faculty faculty = facultyRepo.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        Department department = drepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        faculty.setDepartment(department);
        return facultyRepo.save(faculty);
    }
    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return facultyRepo.findByDepartmentName(departmentName);
    }
    public Faculty assignHodToDepartment(int facultyId, int departmentId) {
        Faculty faculty = facultyRepo.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        Department department = new Department();
        department.setDeptid(departmentId);

        faculty.setDepartment(department);
        return facultyRepo.save(faculty);
    }}
