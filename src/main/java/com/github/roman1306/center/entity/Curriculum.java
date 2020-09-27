package com.github.roman1306.center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Curriculum {
    private String name;
    private List<Course> courses;
}
