package com.example.CollegeDetails.controller;


import com.example.CollegeDetails.Service.CollegeService;
import com.example.CollegeDetails.model.College;
import com.example.CollegeDetails.model.Department;
import com.example.CollegeDetails.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @PostMapping("/addCollege")
    public College addCollege(@RequestBody College college){
        return collegeService.addCollege(college);
    }
    @GetMapping("/all")
    public List<College> findAllColleges(){
        return collegeService.getColleges();
    }
    @GetMapping("/id/{id}")
    public College findCollegeById(@PathVariable int id){
        return collegeService.getCollegeById(id);
    }
    @GetMapping("/name/{name}")
    public Optional<College> findCollegeByName(@PathVariable String name){
        return collegeService.getCollegeByName(name);
    }
    @PutMapping("/update/{name}")
    public College updateCollegeByName(@PathVariable String name, @RequestBody College College){
        return collegeService.updateCollegeByName(name, College);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCollegeById(@PathVariable int id){
        return collegeService.deleteCollegeById(id);
    }
    @PostMapping("/{collegeId}/departments")
    public ResponseEntity<?> addDepartmentsToCollege(@PathVariable int collegeId, @RequestBody List<Department> departments) {
        collegeService.addDepartmentsToCollege(collegeId, departments);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{collegeId}/addFaculties")
    public ResponseEntity<String> addFacultiesToCollege(@PathVariable int collegeId, @RequestBody List<Faculty> faculties) {
        try {
            collegeService.addFacultiesToCollege(collegeId, faculties);
            return ResponseEntity.ok("Faculties added to college successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}