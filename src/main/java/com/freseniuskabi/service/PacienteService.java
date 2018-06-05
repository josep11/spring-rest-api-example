package com.freseniuskabi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freseniuskabi.dao.IPacienteDAO;
import com.freseniuskabi.models.Paciente;

@Service
public class PacienteService implements IPacienteService {

	@Autowired
	private IPacienteDAO pacienteDAO;

	@Override
	public Paciente findById(Long id) {
		Paciente obj = this.pacienteDAO.getPacienteById(id);
		return obj;
	}

	@Override
	public List<Paciente> getAllPacientes() {
		return this.pacienteDAO.getAllPacientes();
	}

	@Override
	public void save(Paciente p) {
		this.pacienteDAO.addPaciente(p);
	}

}
