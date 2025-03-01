package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.BasicPageResultVO;
import com.example.demo.model.PageStudent;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

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
    public ResponseEntity<Void> deleteStudent(@PathVariable(value ="id") Integer id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentService.update(student);
        return ResponseEntity.ok(student);
    }
    @GetMapping("search/{id}")
    public ResponseEntity<Student> searchStudent(@PathVariable(value ="id") Integer id){
        Student student = studentService.search(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }
    }
    @PostMapping("redis/add")
    public ResponseEntity<Student> addStudentRedis(@RequestBody Student student){
        studentService.addStudentRedis(student);
        return ResponseEntity.ok(student);
    }
    @PostMapping("redis/delete/{id}")
    public ResponseEntity<Void> deleteStudentRedis(@PathVariable(value ="id") Integer id){
        studentService.deleteStudentRedis(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/list")
    public ResponseEntity<BasicPageResultVO> deleteStudentRedis(PageStudent PageStudent){
        return ResponseEntity.ok(studentService.getStudentPage(PageStudent));
    }

}
