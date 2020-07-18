package com.lack.homework.controller;

import com.lack.homework.dao.CourseDaoImpl;
import com.lack.homework.dao.StudyUserDaoImpl;
import com.lack.homework.entity.Course;
import com.lack.homework.entity.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Collection;

@Controller
public class AddListController {

    @Autowired
    CourseDaoImpl courseDao;

    @GetMapping("/toAdd/{course_id}")
    public String toAdd(Model model, @PathVariable("course_id") Integer course_id){
        Collection<Course> courseLists=courseDao.fetchAllCourse();
        model.addAttribute("Courses",courseLists);//返回给前端，然后前端根据each 展示所有的课程。
        return "AllCourse";
    }

}
