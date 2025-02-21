package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "student", schema = "test")
public class Student {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String chinese;
    String math;
    String english;
}
