package com.online_courses.platform.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="TBL_COURSES")
public class Course{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ncourse_id")
    private Integer idCourse;

    @Column(name="ctitle")
    private String title;

    @Column(name="cdescription")
    private String description;

    @Column(name = "ninstructor_id")
    private Integer idInstructor;

    @Column(name="ncourse_status_id")
    private Integer idCourseStatus;

    @Column(name="bhabilited",insertable = false)
    private Boolean habilited=true;
    
    @CreationTimestamp
    @Column(name="dcreated_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name="dupdated_at", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name="ddeleted_at")
    private LocalDateTime deletedAt;

}
