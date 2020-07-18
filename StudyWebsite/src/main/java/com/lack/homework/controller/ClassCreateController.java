package com.lack.homework.controller;

import com.lack.homework.dao.CourseDaoImpl;
import com.lack.homework.dao.VideoDaoImpl;
import com.lack.homework.entity.Course;
import com.lack.homework.entity.Video;
import com.lack.homework.entity.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class ClassCreateController {
    @Autowired
    CourseDaoImpl courseDao;
    @Autowired
    VideoDaoImpl videoDao;

    @PostMapping("toCreate")
    public String toCreate(Lists lists, Model model){
        List<Video> videos=videoDao.fetchAllVideo();
        model.addAttribute("Videos",videos);
        List<Integer> ls=lists.getSt();
        String s=courseDao.getNum().get(0).toString();
        int num=Integer.valueOf(s);
        courseDao.insert(new Course(num+1,lists.getId()));
        for(int i=0;i<lists.getSt().size();i++){
            Course course=new Course();
            course.setVideo_id(ls.get(i));
            course.setCourse_id(num+1);
            courseDao.insert(course);
        }
        return "createClass";
    }
}
