package com.lack.homework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name="fetch_all_video",query = "select s.video_id,s.video_name from Video s")
public class Video {
    @Id
    Integer video_id;
    String video_name;
    Integer course_id;
}
