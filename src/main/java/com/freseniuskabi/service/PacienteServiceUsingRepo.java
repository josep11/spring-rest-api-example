package com.freseniuskabi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.freseniuskabi.dao.PacienteRepository;
import com.freseniuskabi.models.Paciente;

@Service
@Qualifier("PacienteServiceUsingRepo")
public class PacienteServiceUsingRepo implements IPacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public Paciente findById(Long id) {

		return this.pacienteRepository.findOne(id);
	}

	@Override
	public List<Paciente> findAll() {
		return this.pacienteRepository.findAll();
	}

	@Override
	public boolean save(Paciente p) {
		this.pacienteRepository.saveAndFlush(p);
		return true;
	}

	@Override
	public void update(Long id, Paciente p) {
		this.pacienteRepository.saveAndFlush(p);
	}

	@Override
	public void delete(Long id) {
		this.pacienteRepository.delete(id);
	}

	@Override
	public boolean exists(Long id) {
		return this.pacienteRepository.exists(id);
	}

}
