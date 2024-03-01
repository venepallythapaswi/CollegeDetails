package com.example.CollegeDetails.repository;


import com.example.CollegeDetails.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepo extends JpaRepository<College, Integer> {
    Optional<College> findByName(String name);
}