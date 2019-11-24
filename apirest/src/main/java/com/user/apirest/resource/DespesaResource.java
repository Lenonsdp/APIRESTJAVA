package com.user.apirest.resource;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.apirest.model.Carro;
import com.user.apirest.model.Despesa;
import com.user.apirest.repository.DespesaRepository;

@RestController
@RequestMapping(value = "/api")
public class DespesaResource {

	@Autowired
	DespesaRepository despesarepository;

	@CrossOrigin
	@GetMapping("/despesas/{idCarro}")
	public List<Despesa> GetAllCarro(@PathVariable(value = "idCarro") Long idCarro) {
		return despesarepository.findByIdCarro(idCarro);
	}

	@CrossOrigin
	@GetMapping("/despesa/{id}")
	public Optional<Despesa> GetDespesa(@PathVariable(value = "id") Long id) {
		return despesarepository.findById(id);
	}

	@CrossOrigin
	@GetMapping("/despesas/{idCarro}/{dataIni}/{dataFim}")
	public List<Despesa> GetDespesa(@PathVariable(value = "idCarro") Long idCarro, @PathVariable(value = "dataIni") Date dataIni,
			@PathVariable(value = "dataFim") Date dataFim) {
		return (List<Despesa>) despesarepository.findDespesaByIdCarroAndDataAndData(idCarro, dataIni, dataFim);
	}

	@CrossOrigin
	@PostMapping("/despesa")
	public Despesa salvarDespesa(@RequestBody Despesa desp) {
		return despesarepository.save(desp);
	}

	@CrossOrigin
	@PutMapping("/despesa/{id}")
	public ResponseEntity<Carro> AtualizarCarro(@RequestBody Despesa des, @PathVariable long id) {

		Optional<Despesa> desOptional = despesarepository.findById(id);

		if (!desOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		des.setId(id);

		despesarepository.save(des);

		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@DeleteMapping("/despesa/{id}")
	public void deleteCarro(@PathVariable long id) {
		despesarepository.deleteById(id);
	}

}
