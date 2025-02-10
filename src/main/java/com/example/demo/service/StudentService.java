package com.example.demo.service;

import com.example.demo.entity.Student;



public interface StudentService {
    void add(Student student);

    void delete(String id);

    void update(Student student);

    Student search(String id);
}
