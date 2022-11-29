package com.encora.college.controller;

import com.encora.college.models.Department;
import com.encora.college.models.Student;
import com.encora.college.repo.StudentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StundentController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentServiceRepository studentServiceRepository;

    @GetMapping("/studentDetail/{departmentName}")
    public List<Student> getStudentDetailsByDepartmentName(@PathVariable String departmentName) {
        String departmentId = Objects.requireNonNull(restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + departmentName, Department.class)).getDepartementId();
       return studentServiceRepository.findByDepartmentId(departmentId);
    }

    @GetMapping("/{studentName}")
    public Student getDepartmentByStudentName(@PathVariable String studentName) {
       return studentServiceRepository.findByStudentName(studentName);
    }
}
