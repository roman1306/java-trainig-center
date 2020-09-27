package com.github.roman1306.center.service;

import com.github.roman1306.center.entity.Student;
import com.github.roman1306.center.service.sort.TypeSortStudent;

import java.util.List;

public interface StudentService {

    List<Student> getStudentsList();

    void overviewStudent(String nameStudent);

    void overviewStudentsSortList(TypeSortStudent typeSortStudent);
}
