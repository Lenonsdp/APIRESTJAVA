package com.user.apirest.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.apirest.model.User;
import com.user.apirest.repository.UserRepository;


@RestController
@RequestMapping(value = "/api")
public class UserResource {

	@Autowired
	UserRepository userRepository;

	@CrossOrigin
	@GetMapping("/users")
	public List<User> GetAll() {
		return userRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/user/{email}/{senha}")
	public Optional<User> GetUser(@PathVariable(value = "email") String email, @PathVariable(value = "senha") String senha) {
		return userRepository.findByEmailAndSenha(email, senha);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public User salvarUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
