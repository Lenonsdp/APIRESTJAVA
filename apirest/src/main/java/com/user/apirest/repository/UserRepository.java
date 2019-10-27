package com.user.apirest.repository;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.apirest.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findById(String id);
}
