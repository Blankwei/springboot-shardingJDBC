package com.example.dao;

import com.example.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    List<Teacher> selectByIds(List<Long> list);

    void insert(Teacher teacher);

    void insertWithId(Teacher teacher);

    void update(Long id, String sex, String name);

    Teacher selectById(Long id);

    void delete(Long id);

    List<Teacher> findList();

    List<Map<String,Object>> findJoin();
}
