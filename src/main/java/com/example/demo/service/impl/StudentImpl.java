package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapping.StudentMapper;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    final StudentMapper studentMapper;
    final StringRedisTemplate stringRedisTemplate;

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public Student search(Integer id) {
        Student student = studentMapper.searchStudentById(id);
        return student;
    }
    @Override
    public void addStudentRedis(Student student) {
        stringRedisTemplate.opsForValue().set("student:" + student.getId(), student.toString());
    }
    @Override
    public void deleteStudentRedis(Integer id) {
        stringRedisTemplate.delete("student:" + id);
    }

}
