package com.example.myspringproject.database;

import com.example.myspringproject.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.Vector;

public class StudentsDB extends DatabaseConfig {
    public Vector<Student> getStudents() throws SQLException {
        Connection connection = getConnection();

        String query = "SELECT * FROM spring_schema.students";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        Vector<Student> studentVector = new Vector<>();

        while(resultSet.next()){
            studentVector.add(
                    new Student(
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getInt("age"),
                            resultSet.getString("role"),
                            resultSet.getInt("id")
                    )
            );
        }

        return studentVector;
    }
}
