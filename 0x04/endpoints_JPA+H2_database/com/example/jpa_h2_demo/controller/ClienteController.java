package com.example.jpa_h2_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/addClient")
	public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatusCode.valueOf(200));
	}

	@GetMapping("/findAllClients")
	public ResponseEntity<List<Cliente>> findAllClients() {
		return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatusCode.valueOf(200));
	}

	@GetMapping("/findClientById/{id}")
	public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
		// TODO
		return new ResponseEntity<Cliente>(clienteRepository.findById(idClient).get(), HttpStatusCode.valueOf(200));
	}

	@DeleteMapping("/removeClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable("id") Long idClient) {
		clienteRepository.deleteById(idClient);
	}

	@PutMapping("/updateClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            clienteRepository.save(cliente); 
        } 
	}

}
