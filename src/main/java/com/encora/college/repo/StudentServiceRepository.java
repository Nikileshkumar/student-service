package com.encora.college.repo;

import com.encora.college.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentServiceRepository extends JpaRepository<Student, String> {
    List<Student> findByDepartmentId(String departmentId);

    Student findByStudentName(String studentName);
}
