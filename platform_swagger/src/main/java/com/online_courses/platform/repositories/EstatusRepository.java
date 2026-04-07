package com.online_courses.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_courses.platform.models.Estatus;

public interface EstatusRepository extends JpaRepository <Estatus, Integer> {

}
