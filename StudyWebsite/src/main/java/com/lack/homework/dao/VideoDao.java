package com.lack.homework.dao;

import com.lack.homework.entity.Course;
import com.lack.homework.entity.Video;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VideoDao {
    //用户数据新增
    Video insert(Video video);
    //用户数据修改
    Video update(Video video);
    //用户数据删除
    void deleteById(Integer videoId);
    //根据id查询用户信息
    Video findById(Integer videoId);
    //查询所有
    List<Video> fetchAllVideo();
}
