package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.mapping.StudentMapper;
import com.example.demo.model.BasicPageResultVO;
import com.example.demo.model.PageStudent;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.netty.NettyProperties;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    final StudentMapper studentMapper;
    final StringRedisTemplate stringRedisTemplate;
    private final NettyProperties nettyProperties;

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

    @Override
    public BasicPageResultVO getStudentPage(PageStudent pageStudent){
        Integer currentPage = pageStudent.getCurrent();
        Integer pageSize = pageStudent.getPageSize();

        Page<Student> page = new Page<>(currentPage, pageSize);

        QueryWrapper<Student> selectQuery = new QueryWrapper<>();

        if (pageStudent.getId() != null){
            selectQuery.eq("id",pageStudent.getId());
        }
        IPage<Student>findList = studentMapper.selectPage(page,selectQuery);

        return createResultVO(findList,currentPage);
    }

    private BasicPageResultVO createResultVO(IPage<Student> findList, Integer currentPage){
        BasicPageResultVO<Student> resultVO = new BasicPageResultVO<>();
        resultVO.setCurrent(findList.getCurrent());
        resultVO.setPageSize(findList.getSize());
        resultVO.setTotal(findList.getTotal());
        long totalPage = findList.getTotal() % findList.getSize() == 0?
                findList.getTotal() / findList.getSize() :
                findList.getTotal() / findList.getSize() + 1;
        resultVO.setPageTotal(totalPage);

        resultVO.setList(findList.getRecords());

        resultVO.setPrePage(currentPage - 1L);

        long nextPage = currentPage + 1;
        if (nextPage <= resultVO.getPageTotal()){
            resultVO.setNextPage(nextPage);
        } else {
            resultVO.setNextPage(0L);
        }
        return resultVO;
    }
}
