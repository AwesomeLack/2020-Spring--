package com.lack.homework.dao;

import com.lack.homework.entity.StudyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudyUserDaoImpl implements StudyUserDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public StudyUser insert(StudyUser studyUser) {
        return entityManager.merge(studyUser);
    }

    @Override
    public StudyUser update(StudyUser studyUser) {
        return entityManager.merge(studyUser);
    }

    @Override
    public void deleteById(Integer id) {
        StudyUser studyUser = findById(id);
        entityManager.remove(studyUser);
    }

    @Override
    public StudyUser findById(Integer id) {
        return entityManager.find(StudyUser.class,id);
    }

    @Override

    public StudyUser findByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject("select * from study_user where username = ?",
                    new Object[]{username},new BeanPropertyRowMapper<StudyUser>(StudyUser.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<StudyUser> fetchAllStudyUser() {
        TypedQuery<StudyUser> fetch_all_studyUsers =
                entityManager.createNamedQuery("fetch_all_StudyUsers",StudyUser.class);
        return fetch_all_studyUsers.getResultList();
    }

    public List<StudyUser> fetchAllCourseName() {
        return jdbcTemplate.query("select course_id,course_name from study_user",
                new BeanPropertyRowMapper<StudyUser>(StudyUser.class));
    }

    @Override
    public int insertNewUser(StudyUser studyUser) {
        return jdbcTemplate.update("insert into study_user (username,password) values (?,?)",
                new Object[]{studyUser.getUsername(),studyUser.getPassword()});
    }


}
