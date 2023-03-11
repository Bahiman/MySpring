package com.example.myspringproject;

import com.example.myspringproject.database.StudentsDB;
import com.example.myspringproject.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
@RequestMapping("students")
@Controller
public class StudentController {

    @GetMapping("/save")
    public String saveNewStudents() {
        return "students";
    }
    @GetMapping("/new")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new-student";
    }
    @GetMapping("/param")
    private String getStudent(
            @RequestParam(name = "name", defaultValue = "") String student_name,
            @RequestParam(name = "surname", defaultValue = "" ) String studentSurname,
            Model model
    ) throws SQLException {

        StudentsDB studentsDB = new StudentsDB();

        Vector<Student> studentVector = studentsDB.getStudents();

        Vector<Student> sortedName =  new Vector<>();

        Vector<Student> sortedSurname = new Vector<>();

        Vector<Student> sortedNameAndSurname = new Vector<>( );

        for(Student student : studentVector){
            if(student.name().equals(student_name)){
                sortedName.add(student);
            }

            if (student.surname().equals(studentSurname)) {
                sortedSurname.add(student);
            }

            if (student.name().equals(student_name) && student.surname().equals(studentSurname)) {
                sortedNameAndSurname.add(student);
            }
        }

        if(!student_name.equals("") && !studentSurname.equals("")){
            model.addAttribute("students", sortedNameAndSurname);
        } else if (!student_name.equals("")){
            model.addAttribute("students", sortedName);
        } else if(!studentSurname.equals("")){
            model.addAttribute("students", sortedSurname);
        } else{
            model.addAttribute("students", studentVector);
        }

//        model.addAttribute("students", studentsDB);

        return "students";
    }
}
