package com.encora.college.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {

    private String student_name;

    @Id
    private String student_id;

    private String department_id;
}
