package com.example.myspringproject.model;

public record Student(
        String name,
        String surname,
        Integer age,
        String role,
        Integer id
) {
    public Student(){
        this(null,null,null,null,null);
    }
}
