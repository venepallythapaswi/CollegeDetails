package com.example.CollegeDetails.controller;


import com.example.CollegeDetails.Service.FacultyService;
import com.example.CollegeDetails.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")

public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @GetMapping("/byCollegeName/{collegeName}")
    public ResponseEntity<List<Faculty>> getFacultiesByCollegeName(@PathVariable String collegeName) {
        List<Faculty> faculties = facultyService.getFacultiesByCollegeName(collegeName);
        return ResponseEntity.ok(faculties);
    }
    @PostMapping("/{facultyId}/assignDepartment/{departmentId}")
    public Faculty assignFacultyToDepartment(@PathVariable int facultyId, @PathVariable int departmentId) {
        return facultyService.assignFacultyToDepartment(facultyId, departmentId);
    }
    @GetMapping("/byDepartmentName/{departmentName}")
    public ResponseEntity<List<Faculty>> getFacultiesByDepartmentName(@PathVariable String departmentName) {
        List<Faculty> faculties = facultyService.getFacultiesByDepartmentName(departmentName);
        return ResponseEntity.ok(faculties);
    }
    @PutMapping("/{facultyId}/assignHod/{departmentId}")
    public ResponseEntity<Faculty> assignHodToDepartment(@PathVariable int facultyId, @PathVariable int departmentId) {
        Faculty hodFaculty = facultyService.assignHodToDepartment(facultyId, departmentId);
        return ResponseEntity.ok(hodFaculty);
    }
}