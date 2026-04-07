package com.online_courses.platform.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CAT_COURSE_STATUS")
public class Estatus {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ncourse_status_id")
    private Integer idCourseStatus;

    @Column(name="cestatus_code")
    private String estatus_code;

    @Column(name="cestatus_name")
    private String estatus_name;

    @Column(name="bhabilited")
    private Boolean habilited;
    
    @Column(name="dcreated_at")
    private Date created_at;
}
