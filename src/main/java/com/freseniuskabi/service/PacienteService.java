package com.freseniuskabi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.freseniuskabi.dao.IPacienteDAO;
import com.freseniuskabi.models.Paciente;

@Service
@Qualifier("PacienteService")
public class PacienteService implements IPacienteService {

	@Autowired
	// @Qualifier("pacienteDAOMock")
	@Qualifier("pacienteDAO")
	private IPacienteDAO pacienteDAO;

	@Override
	public Paciente findById(Long id) {
		Paciente obj = this.pacienteDAO.getPacienteById(id);
		return obj;
	}

	@Override
	public List<Paciente> findAll() {
		return this.pacienteDAO.getAllPacientes();
	}

	@Override
	public synchronized boolean save(Paciente p) {
		Long id = p.getId() != null ? p.getId() : -1;
		if (this.pacienteDAO.pacienteExists(id)) {
			return false;
		} else {
			this.pacienteDAO.addPaciente(p);
			return true;
		}
	}

	@Override
	public void delete(Long id) {
		this.pacienteDAO.deletePaciente(id);
	}

	@Override
	public void update(Long id, Paciente p) {
		this.pacienteDAO.updatePaciente(id, p);
	}

	@Override
	public boolean exists(Long id) {
		return this.pacienteDAO.pacienteExists(id);
	}

}
