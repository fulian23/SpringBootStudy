package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.BasicPageResultVO;
import com.example.demo.model.PageStudent;


public interface StudentService {
    void add(Student student);

    void delete(Integer id);

    void update(Student student);

    Student search(Integer id);

    void addStudentRedis(Student student);

    void deleteStudentRedis(Integer id);

    BasicPageResultVO getStudentPage(PageStudent pageStudent);
}
