package com.freseniuskabi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.freseniuskabi.models.Paciente;
import com.freseniuskabi.service.IPacienteService;

@RestController
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	@Qualifier("PacienteServiceUsingRepo")
	private IPacienteService pacienteService;

	@GetMapping
	public List<Paciente> defaultCall() {
		return this.getAllPacientes();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Paciente> getAllPacientes() {
		List<Paciente> list = this.pacienteService.findAll();
		return list;
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> addPaciente(@RequestBody Paciente paciente, UriComponentsBuilder builder) {
		boolean flag = this.pacienteService.save(paciente);
		if (flag == false) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/Paciente/{id}").buildAndExpand(paciente.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") Long id, @RequestBody Paciente p) {

		Paciente currentPaciente = this.pacienteService.findById(id);
		if (currentPaciente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// TODO:password won't be here because of the JsonIgnore
		this.pacienteService.update(id, p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletePaciente(@PathVariable("id") Long id) {
		if (!this.pacienteService.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.pacienteService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
