package com.contatos.apirest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.repository.*;
import com.contatos.apirest.model.*;

@RestController
@RequestMapping(value="/api")
public class ContatoResource {

	
	@Autowired
	ContatoRepository contatorepository;
	
	@GetMapping("/contatos")
	public List<Contato> GetAllContatos(){
		return contatorepository.findAll();
	}
}
