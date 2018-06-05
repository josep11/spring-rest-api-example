package com.freseniuskabi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freseniuskabi.models.Paciente;

@Service
public interface IPacienteService {

	Paciente findById(Long id);

	List<Paciente> getAllPacientes();

	void save(Paciente p);
}
