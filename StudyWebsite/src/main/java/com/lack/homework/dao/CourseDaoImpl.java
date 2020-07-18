package com.lack.homework.dao;

import com.lack.homework.entity.Course;
import com.lack.homework.entity.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Course insert(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void deleteById(Integer courseId) {
        Course course = findById(courseId);
        entityManager.remove(course);
    }

    @Override
    public Course findById(Integer courseId) {
        return entityManager.find(Course.class,courseId);
    }


//    @Override
//    public List<Course> fetchAllCourse() {
//        TypedQuery<Course> fetch_all_course =
//                entityManager.createNamedQuery("fetch_all_course",Course.class);
//        return fetch_all_course.getResultList();
//    }
@Override
public List<Course> fetchAllCourse() {
    return jdbcTemplate.query("select course_id,course_name from Course",
            new BeanPropertyRowMapper<Course>(Course.class));
}

    @Override
    public List<BigInteger> getNum( ){
        Query query =  entityManager.createNativeQuery("select count(course_id) from Course");
        return query.getResultList();
    }


}
