package com.user.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.apirest.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	List<Carro> findByIdUser(Long idUser);
}
