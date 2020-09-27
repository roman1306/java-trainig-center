package com.github.roman1306.center.init;

import com.github.roman1306.center.entity.Curriculum;
import com.github.roman1306.center.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitialStudents {

    public List<Student> initStudents(List<Curriculum> curriculumList) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivanov Ivan", curriculumList.get(0),
                Stream.of(3, 4, 5, 5, 3, 3).collect(Collectors.toList()),
                LocalDate.now().minusDays(6)));
        students.add(new Student("Petrov Petr", curriculumList.get(1),
                Stream.of(4, 5, 3, 2, 3, 3, 5, 5).collect(Collectors.toList()),
                LocalDate.now().minusDays(8)));
        students.add(new Student("Romanov Roman", curriculumList.get(0),
                Stream.of(3, 4, 2).collect(Collectors.toList()),
                LocalDate.now().minusDays(3)));

        return students;
    }
}
