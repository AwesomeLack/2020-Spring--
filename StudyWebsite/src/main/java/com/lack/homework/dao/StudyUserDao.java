package com.lack.homework.dao;
import com.lack.homework.entity.StudyUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudyUserDao {
    //用户数据新增
    StudyUser insert(StudyUser studyUser);
    //用户数据修改
    StudyUser update(StudyUser studyUser);
    //用户数据删除
    void deleteById(Integer id);
    //根据id查询用户信息
    StudyUser findById(Integer id);
    //根据username查询用户信息
    StudyUser findByUsername(String username);
    //查询所有
    List<StudyUser> fetchAllStudyUser();
    List<StudyUser> fetchAllCourseName();

    //新增用户
    int insertNewUser(StudyUser studyUser);

}
