package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@TableName(value = "student", schema = "test")
public class Student {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @NotBlank(message = "语文成绩不能为空")
    String chinese;
    @NotBlank(message = "数学成绩不能为空")
    String math;
    @NotBlank(message = "英语成绩不能为空")
    String english;
}
