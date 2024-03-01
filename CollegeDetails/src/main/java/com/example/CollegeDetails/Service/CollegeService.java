package com.example.CollegeDetails.Service;


import com.example.CollegeDetails.model.College;
import com.example.CollegeDetails.model.Department;
import com.example.CollegeDetails.model.Faculty;
import com.example.CollegeDetails.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepo repo;
    public College addCollege(College college) {
        return repo.save(college);
    }

    public List<College> getColleges() {
        return repo.findAll();
    }

    public College getCollegeById(int id) {
        return repo.findById(id).orElse(null);
    }
    public Optional<College> getCollegeByName(String name) {
        return repo.findByName(name);
    }

    public College updateCollegeByName(String name, College updatedCollege) {
        Optional<College> optionalCollege = repo.findByName(name);
        if(optionalCollege.isPresent()){
            College existingCollege = optionalCollege.get();
            existingCollege.setId(updatedCollege.getId());
            existingCollege.setName(updatedCollege.getName());
            return repo.save(existingCollege);
        }
        else {
            throw new RuntimeException("College with name " + name + " is not found");
        }
    }

    public String deleteCollegeById(int id) {
        repo.deleteById(id);
        return "College with id " + id + " is deleted";
    }
    public void addDepartmentsToCollege(int collegeId, List<Department> departments) {
        College college = repo.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));

        for (Department department : departments) {
            department.setCollege(college);
            college.getDepartments().add(department);
        }
        repo.save(college);
    }
    public void addFacultiesToCollege(int collegeId, List<Faculty> faculties) {
        College college = repo.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));

        for (Faculty faculty : faculties) {
            faculty.setCollege(college);
            college.getFaculties().add(faculty);
        }
        repo.save(college);
    }
}