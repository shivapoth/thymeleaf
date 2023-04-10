package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ojas.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
