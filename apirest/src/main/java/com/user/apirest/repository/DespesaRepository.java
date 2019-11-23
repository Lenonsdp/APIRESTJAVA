package com.user.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.apirest.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{


	List<Despesa> findByIdCarro(Long idCarro);

}
