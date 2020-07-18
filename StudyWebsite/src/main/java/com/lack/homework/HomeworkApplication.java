package com.lack.homework;

import com.lack.homework.dao.CourseDaoImpl;
import com.lack.homework.dao.StudyUserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseDaoImpl courseDao;
	@Autowired
	StudyUserDaoImpl studyUserDao;

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("--->{}",studyUserDao.fetchAllCourseName());
//		System.out.println(courseDao.fetchAllCourse());
//		System.out.printf(String.valueOf(studyUserDao.fetchAllCourseName()));
	}

}
