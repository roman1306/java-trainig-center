package com.github.roman1306.center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private Curriculum curriculum;
    private List<Integer> marks;
    private LocalDate startDate;

    @Override
    public String toString() {
        StringBuilder courses = new StringBuilder();
        for (Course course : curriculum.getCourses()) {
            courses.append("\n").append(course.getName()).append(" ").append(course.getDuration().toHours()).append("ч");
        }

        return "STUDENT: " + name + "\n" +
                "CURRICULUM: " + curriculum.getName() + "\n" +
                "START_DATE: " + startDate + "\n" +
                "MARKS: " + marks + "\n" +
                "COURSES: " + courses + "\n";
    }
}
