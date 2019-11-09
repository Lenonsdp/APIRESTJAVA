package com.user.apirest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.user.apirest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndSenha(String email, String senha);
}
