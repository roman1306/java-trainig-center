package com.github.roman1306.center.init;

import com.github.roman1306.center.entity.Course;
import com.github.roman1306.center.entity.Curriculum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InitialCurriculum {

    public List<Curriculum> initCurriculum(List<Course> coursesList) {
        List<Curriculum> curriculumList = new ArrayList<>();
        curriculumList.add(new Curriculum("J2EE Developer", coursesList.stream().filter(p ->
                p.getName().equals("Technology Java Servlets") ||
                        p.getName().equals("Struts Framework") ||
                        p.getName().equals("Spring Framework") ||
                        p.getName().equals("Hibernate"))
                .collect(Collectors.toList())));
        curriculumList.add(new Curriculum("Java Developer", coursesList.stream().filter(p ->
                p.getName().equals("Technology Java") ||
                        p.getName().equals("Library JFC/Swing") ||
                        p.getName().equals("Technology JDBC") ||
                        p.getName().equals("Technology JAX") ||
                        p.getName().equals("Library commons"))
                .collect(Collectors.toList())));

        return curriculumList;
    }
}
