package com.online_courses.platform.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_courses.platform.models.Course;
import com.online_courses.platform.services.CourseService;

@RestController
@RequestMapping("/courses")

public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service){
        this.service=service;
    }

    @GetMapping("/{idCourse}")
    public Course courseById(@PathVariable int idCourse){
        return service.findById(idCourse);
    }

    @GetMapping
    public List<Course> ShowAllCourses(){
        return service.findAll();
    }

    @PostMapping
    public Course newCourse(@RequestBody Course course){
        return service.newCourse(course);
    }
}
