package com.user.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.apirest.model.Despesa;
import com.user.apirest.repository.DespesaRepository;

@RestController
@RequestMapping(value = "/api")
public class DespesaResource {

	@Autowired
	DespesaRepository despesarepository;
	
	@CrossOrigin
	@GetMapping("/despesas")
	public List<Despesa> GetAll() {
		return despesarepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public Despesa salvarDespesa(@RequestBody Despesa desp) {
		return despesarepository.save(desp);
	}
	
}
