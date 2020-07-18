package com.lack.homework.dao;

import com.lack.homework.entity.Course;
import com.lack.homework.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VideoDaoImpl implements VideoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Video insert(Video video) {
        return entityManager.merge(video);
    }

    @Override
    public Video update(Video video) {
        return entityManager.merge(video);
    }

    @Override
    public void deleteById(Integer videoId) {
        Video video = findById(videoId);
        entityManager.remove(video);
    }

    @Override
    public Video findById(Integer videoId) {
        return entityManager.find(Video.class,videoId);
    }


    @Override
    public List<Video> fetchAllVideo() {
            return jdbcTemplate.query("select video_id,video_name from video",
                    new BeanPropertyRowMapper<Video>(Video.class));
    }
}


