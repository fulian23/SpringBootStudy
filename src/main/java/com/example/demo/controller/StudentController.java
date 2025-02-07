package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    @PostMapping("add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.add(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
