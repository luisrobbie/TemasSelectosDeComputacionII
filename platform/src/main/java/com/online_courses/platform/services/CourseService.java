package com.online_courses.platform.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.online_courses.platform.models.Course;
import com.online_courses.platform.repositories.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository repository;
    public CourseService(CourseRepository repository){
        this.repository=repository;
    }

    public List<Course> findAll(){
        return repository.findAll();
    }

    public Course findById(Integer idCourse){
        return repository.findById(idCourse).orElse(null);
    }

    public Course newCourse(Course course){
        Course c= new Course();
        c.setTitle(course.getTitle());
        c.setDescription(course.getDescription());
        c.setIdInstructor(course.getIdInstructor());
        c.setIdCourseStatus(course.getIdCourseStatus());
        c.setHabilited(true);
        return repository.save(c);
    }
}
