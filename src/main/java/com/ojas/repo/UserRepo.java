package com.ojas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ojas.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	public UserEntity findByUserNameAndPassword(String uName, String password);
	
}
