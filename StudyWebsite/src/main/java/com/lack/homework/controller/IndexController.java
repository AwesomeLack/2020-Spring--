package com.lack.homework.controller;

import com.lack.homework.dao.CourseDaoImpl;
import com.lack.homework.dao.StudyUserDaoImpl;
import com.lack.homework.dao.VideoDaoImpl;
import com.lack.homework.entity.Course;
import com.lack.homework.entity.StudyUser;
import com.lack.homework.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    VideoDaoImpl videoDao;
    @Autowired
    CourseDaoImpl courseDao;
    @Autowired
    StudyUserDaoImpl studyUserDao;


    @GetMapping("/VideoUploads")
    public String videoUpload(){
        return "videoUploads";
    }

    @GetMapping("/CreateClass")
    public String createClass(Model model){
        List<Video> videos=videoDao.fetchAllVideo();
        model.addAttribute("Videos",videos);
        return "createClass";
    }

    @GetMapping("/AllCourse")
    public String AllCourse(Model model){
        List<Course> courses=courseDao.fetchAllCourse();
        model.addAttribute("Courses",courses);
        return "AllCourse";
    }

    @GetMapping("/Personal")
    public String personal(Model model){
        List<StudyUser> studyUser =studyUserDao.fetchAllStudyUser();
        model.addAttribute("StudyUsers",studyUser);
        return "personal";
    }

    @GetMapping("/Learning")
    public String Learning(Model model){
//        List<StudyUser> studyUser =studyUserDao.fetchAllStudyUser();
//        model.addAttribute("StudyUsers",studyUser);
        return "Learning";
    }

}
