package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
