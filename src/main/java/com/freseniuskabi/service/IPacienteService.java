package com.freseniuskabi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freseniuskabi.models.Paciente;

@Service
public interface IPacienteService {

	Paciente findById(Long id);

	List<Paciente> findAll();

	boolean save(Paciente p);

	void update(Long id, Paciente p);

	void delete(Long id);

	boolean exists(Long id);

}
