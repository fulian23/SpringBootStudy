package com.example.demo.mapping;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    //插入记录
    @Insert("INSERT INTO student (id, name, chinese, math, english) VALUES (#{id}, #{name}, #{chinese}, #{math}, #{english})")
    void insertStudent(Student student);
    //删除记录
    @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteStudentById(Integer id);
    //更新记录
    @Update("UPDATE student SET name = #{name}, chinese = #{chinese}, math = #{math}, english = #{english} WHERE id = #{id}")
    void updateStudent(Student student);
    // 查询记录
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student searchStudentById(Integer id);

}
