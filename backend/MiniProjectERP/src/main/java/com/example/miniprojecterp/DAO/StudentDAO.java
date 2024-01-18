package com.example.miniprojecterp.DAO;

import com.example.miniprojecterp.Bean.Student;

import java.util.List;

public interface StudentDAO {
    public Student getStudent(int id);

    public List<Student> getDomainStudents(int dom);
}

