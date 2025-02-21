package com.example.demo.service;

import com.example.demo.entity.Student;



public interface StudentService {
    void add(Student student);

    void delete(Integer id);

    void update(Student student);

    Student search(Integer id);

    void addStudentRedis(Student student);

    void deleteStudentRedis(Integer id);
}
