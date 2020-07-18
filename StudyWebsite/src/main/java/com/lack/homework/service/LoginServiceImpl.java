package com.lack.homework.service;

import com.lack.homework.dao.StudyUserDaoImpl;
import com.lack.homework.entity.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    StudyUserDaoImpl studyUserDao;

    @Override
    public String login(String username,String password) {
        StudyUser studyUser = studyUserDao.findByUsername(username);
        if(studyUser!=null&&studyUser.getPassword().equals(password)){
            return "dashboard";
        }else {
            return "login";
        }
    }
}
