package com.lack.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name="fetch_all_course",query = "select s.course_id,s.course_name from Course s")
public class Course {

    Integer video_id;
    @Id
    Integer course_id;
    String course_name;
    String video_name;

    public Course(Integer courseId ,String courseName) {
        this.course_id=courseId;
        this.course_name=courseName;
        this.video_id=courseId;
    }
}
