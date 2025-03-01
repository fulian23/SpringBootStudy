package com.example.demo.model;

import lombok.Data;
import java.util.List;

@Data
public class BasicPageResultVO<T> {
    Long current = 1L;
    Long pageSize = 20L;
    Long total;
    Long pageTotal;
    Long nextPage;
    Long prePage;
    List<T> list;
}
