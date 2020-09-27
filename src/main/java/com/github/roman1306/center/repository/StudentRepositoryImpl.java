package com.github.roman1306.center.repository;

import com.github.roman1306.center.entity.Course;
import com.github.roman1306.center.entity.Curriculum;
import com.github.roman1306.center.entity.Student;
import com.github.roman1306.center.init.InitialCourses;
import com.github.roman1306.center.init.InitialCurriculum;
import com.github.roman1306.center.init.InitialStudents;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final List<Course> coursesList = new InitialCourses().initCourses();
    private final List<Curriculum> curriculumList = new InitialCurriculum().initCurriculum(coursesList);
    private final List<Student> studentsList = new InitialStudents().initStudents(curriculumList);

    @Override
    public Student findStudent(String nameStudent) {
        return studentsList.stream().filter(p -> p.getName().equals(nameStudent)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getStudentsList() {
        return studentsList;
    }
}
