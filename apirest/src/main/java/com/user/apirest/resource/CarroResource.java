package com.user.apirest.resource;

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
import com.user.apirest.repository.CarroRepository;

@RestController
@RequestMapping(value = "/api")
public class CarroResource {

	@Autowired
	CarroRepository carroRepository;

	@CrossOrigin
	@GetMapping("/carros/{idUser}")
	public List<Carro> GetAllCarro(@PathVariable(value = "idUser") Long idUser) {
		return carroRepository.findByIdUser(idUser);
	}

	@CrossOrigin
	@GetMapping("/carro/{id}")
	public Optional<Carro> GetCarro(@PathVariable(value = "id") Long id) {

		return carroRepository.findById(id);
	}

	@CrossOrigin
	@PostMapping("/carro")
	public Carro salvarCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}

	@CrossOrigin
	@PutMapping("/carro/{id}")
	public ResponseEntity<Carro> AtualizarCarro(@RequestBody Carro carro, @PathVariable long id) {

		Optional<Carro> carroOptional = carroRepository.findById(id);

		if (!carroOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		carro.setId(id);
		
		carroRepository.save(carro);

		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping("/carro/{id}")
	public void deleteCarro(@PathVariable long id) {
		carroRepository.deleteById(id);
	}
	

}
