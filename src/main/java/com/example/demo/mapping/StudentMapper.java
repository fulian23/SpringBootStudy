package com.example.demo.mapping;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface StudentMapper {
    //插入记录
    @Insert("INSERT INTO student (id, name, chinese, math, english) VALUES (#{id}, #{name}, #{chinese}, #{math}, #{english})")
    void insertStudent(Student student);
    //删除记录
    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteStudentById(String id);
}
