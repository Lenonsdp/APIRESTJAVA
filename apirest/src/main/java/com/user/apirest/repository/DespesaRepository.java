package com.user.apirest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.apirest.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{


	List<Despesa> findByIdCarro(Long idCarro);

	@Query("SELECT d FROM Despesa d WHERE d.idCarro = ?1 and d.data >= ?2 and d.data <= ?3 ")
	List<Despesa> findDespesaByIdCarroAndDataAndData(Long idCarro, Date dataIni, Date datFim);
}
