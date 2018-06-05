package com.freseniuskabi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freseniuskabi.models.Paciente;
import com.freseniuskabi.service.IPacienteService;

@RestController
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	private IPacienteService pacienteService;

	@RequestMapping
	public List<Paciente> defaultCall() {
		return this.getAllPacientes();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Paciente> getAllPacientes() {
		List<Paciente> list = this.pacienteService.getAllPacientes();
		// List<Paciente> list = new ArrayList<>();
		// list.add(new Paciente("aa", "999999999999"));
		return list;
	}

}
