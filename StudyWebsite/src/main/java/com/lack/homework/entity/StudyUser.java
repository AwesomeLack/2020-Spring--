package com.lack.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "study_user")
@NamedQueries({
        @NamedQuery(name="fetch_all_StudyUsers",query = "select s from StudyUser s"),
        @NamedQuery(name="fetch_all_CourseName",query = "select s.courseName from StudyUser s")})
public class StudyUser {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String department;
    private Integer stu_id;
    private Integer gender; //0女1男
    private String grade;
    private String major;
    private Integer courseId;
    private String courseName;

    public StudyUser(String username,String password){
        this.username=username;
        this.password=password;
    }
}
