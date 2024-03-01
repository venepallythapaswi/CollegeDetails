package com.example.CollegeDetails.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name="department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int deptid;
    public String name;
    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonIgnore
    private College college;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Faculty> faculties = new ArrayList<>();
    @OneToOne(mappedBy = "department")
    private Faculty hod;
    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
    public Faculty getHod() {
        return hod;
    }

    public void setHod(Faculty hod) {
        this.hod = hod;
    }
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return name;
    }

    public void setDeptname(String deptname) {
        this.name = deptname;
    }
    public String getHodName() {
        if (hod != null) {
            return hod.getName();
        } else {
            return null;
        }
    }
}