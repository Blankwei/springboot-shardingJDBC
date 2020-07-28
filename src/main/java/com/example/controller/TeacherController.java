package com.example.controller;

import com.example.pojo.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Author: created by savoidage
 * CreateTime: 2020-07-06 18:49
 * Description: TeacherController
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 根据查询教师信息
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    public Object get(@PathVariable String id){
        //分割url
        String[] str = id.split(",");
        List<Long> list = new ArrayList<>();
        for (int i=0;i<str.length;i++){
            list.add(Long.parseLong(str[i]));
        }
        List<Teacher> l = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Teacher t = teacherService.selectById((Long)iterator.next());
            l.add(t);
            iterator.remove();
        }
        return l;
    }

    /**
     * 默认添加50条数据
     * @return
     */
    @RequestMapping("/add")
    public Object add(){
        for (int i=0;i<50;i++){
            Teacher teacher = new Teacher();
            teacher.setId(Long.parseLong(i+""));
            teacher.setName("mary");
            teacher.setSex("girl");
            teacherService.add(teacher);
        }
        return "success";
    }

    /**
     * 更新数据
     * @param s
     * @return
     */
    @RequestMapping("/update/{s}")
    public Object update(@PathVariable String s){
        String[] str = s.split(",");
        Long id = Long.parseLong(str[0]);
        String sex = str[1];
        String name = str[2];
        teacherService.update(id,sex,name);
        return "success";
    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable Long id){
        teacherService.delete(id);
        return "success";
    }

    /**
     * 查询列表
     * @return
     */
    @GetMapping("/findList")
    public Object findList(){
        List<Teacher> list = (List<Teacher>) teacherService.findList();
        Map<String,Object> map = new HashMap<>();
        map.put("count",list.size());
        map.put("list",list);
        return map;
    }

    /**
     * 测试跨库关联查询
     * @return
     */
    @GetMapping("/getMap")
    public List<Map<String,Object>> findMap(){
        return teacherService.findMap();
    }

}
