package com.example.service;

import com.example.pojo.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Author: created by savoidage
 * CreateTime: 2020-07-06 18:49
 * Description: TeacherService
 */
public interface TeacherService {

    List<Teacher> get(List<Long> list);

    void add(Teacher teacher);

    void update(Long id, String sex, String name);

    Teacher selectById(Long id);

    void delete(Long id);

    Object findList();

    List<Map<String,Object>> findMap();
}
