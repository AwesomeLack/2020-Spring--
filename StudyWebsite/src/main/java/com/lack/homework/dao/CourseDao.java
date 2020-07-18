package com.lack.homework.dao;

import com.lack.homework.entity.Course;
import com.lack.homework.entity.StudyUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface CourseDao {
    //用户数据新增
    Course insert(Course course);
    //用户数据修改
    Course update(Course course);
    //用户数据删除
    void deleteById(Integer courseId);
    //根据id查询用户信息
    Course findById(Integer courseId);
    //查询所有
    List<Course> fetchAllCourse();
    public List<BigInteger> getNum();
}
