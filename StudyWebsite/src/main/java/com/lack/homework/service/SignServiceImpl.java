package com.lack.homework.service;

import com.lack.homework.dao.StudyUserDaoImpl;
import com.lack.homework.entity.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl implements SignService{

    @Autowired
    StudyUserDaoImpl studyUserDao;

    @Override
    public String sign(String username,String password,String password1) {
        if(studyUserDao.findByUsername(username)!=null){
            return "sign";
        }
        studyUserDao.insertNewUser(new StudyUser(username, password));
        return "redirect:/Login";
    }
}
