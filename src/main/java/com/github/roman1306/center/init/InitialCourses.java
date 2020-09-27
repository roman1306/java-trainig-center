package com.github.roman1306.center.init;

import com.github.roman1306.center.entity.Course;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InitialCourses {

    public List<Course> initCourses() {
        List<Course> courses = new ArrayList<>();

        courses.add(new Course("Technology Java Servlets", Duration.ofHours(16)));
        courses.add(new Course("Struts Framework", Duration.ofHours(24)));
        courses.add(new Course("Spring Framework", Duration.ofHours(48)));
        courses.add(new Course("Hibernate", Duration.ofHours(20)));
        courses.add(new Course("Overview technology Java", Duration.ofHours(8)));
        courses.add(new Course("Library JFC/Swing", Duration.ofHours(16)));
        courses.add(new Course("Technology JDBC", Duration.ofHours(16)));
        courses.add(new Course("Technology JAX", Duration.ofHours(52)));
        courses.add(new Course("Library commons", Duration.ofHours(44)));

        return courses;
    }
}
