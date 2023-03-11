package com.example.myspringproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class TeacherController {
    @GetMapping("/teacher")
    private String getTeacher() {
        return "teachers";
    }
}
