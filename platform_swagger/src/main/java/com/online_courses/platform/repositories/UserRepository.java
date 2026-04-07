package com.online_courses.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_courses.platform.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}
