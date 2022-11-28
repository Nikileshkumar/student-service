package com.encora.college;

import com.encora.college.models.StudentDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class StudentServiceApplication {

    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @GetMapping("/student")
    public String hello(){
        return  "Hello I am in Student service";
    }

    @GetMapping("/studentDetail/{departmentId}")
    public StudentDetails getStudentDetails(@PathVariable("departmentId") String departmentId) {
        StudentDetails studentDetails = new StudentDetails();
        if (departmentId.equals("employee")) {
            studentDetails.setListOfStudents(Arrays.asList("Rahul", "Nikilesh"));
        } else if (departmentId.equals("managers")) {
            studentDetails.setListOfStudents(Arrays.asList("Thimmaiah", "Kishore"));
        }
        return studentDetails;
    }

    @GetMapping("/department/{studentname}")
    public String getDepartmentByStudentName(@PathVariable("studentname") String studentName) {
        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/departmentDetails" + studentName, String.class);
    }

}
