package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapping.StudentMapper;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    final StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        studentMapper.insertStudent(student);

    }

    @Override
    public void delete(String id) {
        studentMapper.deleteStudentById(id);
    }

}
