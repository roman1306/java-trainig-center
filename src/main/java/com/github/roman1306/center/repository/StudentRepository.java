package com.github.roman1306.center.repository;

import com.github.roman1306.center.entity.Student;

import java.util.List;

public interface StudentRepository {

    Student findStudent(String nameStudent);

    List<Student> getStudentsList();
}
