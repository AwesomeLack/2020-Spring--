package com.lack.homework.repo;

import com.lack.homework.entity.StudyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<StudyUser,Integer> {
}
