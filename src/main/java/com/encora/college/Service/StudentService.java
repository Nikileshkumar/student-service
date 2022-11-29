package com.encora.college.Service;

import com.encora.college.models.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/student")
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/student")
    public String hello() {
        return "Hello I am in Student service";
    }

    @RequestMapping("/studentDetail/{departmentId}")
    public StudentDetails getStudentDetails(@PathVariable("departmentId") String departmentId) {
        StudentDetails studentDetails = new StudentDetails();
        if (departmentId.equals("employee")) {
            studentDetails.setListOfStudents(Arrays.asList("Rahul", "Nikilesh"));
        } else if (departmentId.equals("managers")) {
            studentDetails.setListOfStudents(Arrays.asList("Thimmaiah", "Kishore"));
        }
        return studentDetails;
    }

    @RequestMapping("/department/{studentname}")
    public String getDepartmentByStudentName(@PathVariable("studentname") String studentName) {
        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/departmentDetails/" + studentName, String.class);
    }
}
