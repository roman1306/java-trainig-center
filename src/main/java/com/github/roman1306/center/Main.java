package com.github.roman1306.center;

import com.github.roman1306.center.entity.Student;
import com.github.roman1306.center.repository.StudentRepositoryImpl;
import com.github.roman1306.center.service.StudentService;
import com.github.roman1306.center.service.StudentServiceImpl;
import com.github.roman1306.center.service.sort.TypeSortStudent;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl(new StudentRepositoryImpl());
        List<Student> students = studentService.getStudentsList();
        System.out.println(students);
        studentService.overviewStudentsSortList(TypeSortStudent.AVERAGE_MARKS);

    }
}
