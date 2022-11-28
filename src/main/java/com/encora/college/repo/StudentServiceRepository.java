package com.encora.college.repo;

import com.encora.college.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentServiceRepository extends JpaRepository<Student, String> {
}
