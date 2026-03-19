package com.online_courses.platform.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuser_id")
    private Integer idUser;

    @Column(name = "cname")
    private String name;

    @Column(name = "cemail")
    private String email;

    @Column(name = "cpassword_hash")
    private String passwordHash;

    @Column(name= "nrole_id")
    private InternalError idRole;

    @Column(name="dcreated_at")
    private Date createdAt;
    
    @Column(name="dupdated_at")
    private Date updatedAt;
    
    @Column(name="ddeleted_at")
    private Date deletedAt;
}
