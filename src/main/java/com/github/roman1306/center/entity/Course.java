package com.github.roman1306.center.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;

@AllArgsConstructor
@Data
public class Course {
    private String name;
    private Duration duration;
}
