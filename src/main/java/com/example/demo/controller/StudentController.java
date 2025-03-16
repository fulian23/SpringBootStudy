package com.example.demo.controller;

import com.example.demo.entity.ResponseVO;
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
    public ResponseVO<?> addStudent(@RequestBody Student student){
        studentService.add(student);
        return ResponseVO.SUCCESS();
    }

    @DeleteMapping("delete/{id}")
    public ResponseVO<?> deleteStudent(@PathVariable(value ="id") Integer id){
        studentService.delete(id);
        return ResponseVO.SUCCESS();
    }
    @PostMapping("update")
    public ResponseVO<?> updateStudent(@RequestBody Student student){
        studentService.update(student);
        return ResponseVO.SUCCESS(student);
    }
    @GetMapping("search/{id}")
    public ResponseVO<?> searchStudent(@PathVariable(value ="id") Integer id){
        Student student = studentService.search(id);
        if(student == null){
            return ResponseVO.FAIL();
        }else {
            return ResponseVO.SUCCESS(student);
        }
    }
    @PostMapping("redis/add")
    public ResponseVO<?> addStudentRedis(@RequestBody Student student){
        studentService.addStudentRedis(student);
        return ResponseVO.SUCCESS(student);
    }
    @PostMapping("redis/delete/{id}")
    public ResponseVO<?> deleteStudentRedis(@PathVariable(value ="id") Integer id){
        studentService.deleteStudentRedis(id);
        return ResponseVO.SUCCESS();
    }
    @GetMapping("/list")
    public ResponseVO<?> deleteStudentRedis(PageStudent PageStudent){
        return ResponseVO.SUCCESS(studentService.getStudentPage(PageStudent));
    }

}
