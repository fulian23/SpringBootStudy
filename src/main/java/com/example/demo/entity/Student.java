package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Data
@TableName(value = "student", schema = "test")
public class Student {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @NotNull(message = "语文成绩不能为空")
    @DecimalMin(value = "0", message = "语文成绩不能低于0")
    @DecimalMax(value = "150", message = "语文成绩不能超过150")
    Double chinese;
    @NotNull(message = "数学成绩不能为空")
    @DecimalMin(value = "0", message = "数学成绩不能低于0")
    @DecimalMax(value = "150", message = "数学成绩不能超过150")
    Double math;
    @NotNull(message = "英语成绩不能为空")
    @DecimalMin(value = "0", message = "英语成绩不能低于0")
    @DecimalMax(value = "150", message = "英语成绩不能超过150")
    Double english;
}
