package com.freseniuskabi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.freseniuskabi.models.Paciente;

@Repository
@Qualifier("pacienteDAOMock")
public class PacienteDAOMock implements IPacienteDAO {

	@Override
	public List<Paciente> getAllPacientes() {
		List<Paciente> list = new ArrayList<>();
		list.add(new Paciente("hola", "adeu"));
		return list;
	}

	@Override
	public Paciente getPacienteById(Long PacienteId) {
		return new Paciente();
	}

	@Override
	public void addPaciente(Paciente Paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePaciente(Long id, Paciente Paciente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePaciente(Long PacienteId) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean pacienteExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pacienteExists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
