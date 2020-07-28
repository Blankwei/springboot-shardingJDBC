package com.example.service;

import com.example.dao.TeacherMapper;
import com.example.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: created by savoidage
 * CreateTime: 2020-07-06 18:49
 * Description: TeacherServiceImpl
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> get(List<Long> list) {
        List<Teacher> l = teacherMapper.selectByIds(list);
        System.out.println(l);
        return l;
    }

    @Override
    public void add(Teacher teacher) {
        if (null != teacher.getId()) {
            teacherMapper.insertWithId(teacher);
        } else {
            teacherMapper.insert(teacher);
        }
    }

    @Override
    public void update(Long id, String sex, String name) {
        teacherMapper.update(id, sex, name);
    }

    @Override
    public Teacher selectById(Long id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        teacherMapper.delete(id);
    }

    @Override
    public Object findList() {
        return teacherMapper.findList();
    }

    @Override
    public List<Map<String, Object>> findMap() {
        return teacherMapper.findJoin();
    }

}
