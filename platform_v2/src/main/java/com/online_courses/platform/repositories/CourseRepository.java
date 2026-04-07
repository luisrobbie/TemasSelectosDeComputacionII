package com.online_courses.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_courses.platform.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
