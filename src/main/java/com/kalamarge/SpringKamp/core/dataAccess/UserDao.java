package com.kalamarge.SpringKamp.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalamarge.SpringKamp.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
