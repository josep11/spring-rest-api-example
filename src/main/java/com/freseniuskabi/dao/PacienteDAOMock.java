package com.freseniuskabi.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.freseniuskabi.models.Paciente;

@Repository
@Qualifier("pacienteDAOMock")
public class PacienteDAOMock implements IPacienteDAO {

	List<Paciente> list = Arrays.asList(new Paciente("hola", "adeu"), new Paciente("paciente2", "pwd"));

	@Override
	public List<Paciente> getAllPacientes() {
		return this.list;
	}

	@Override
	public Paciente getPacienteById(Long PacienteId) {
		return this.list.stream().filter(p -> p.getId() == PacienteId).findFirst().get();
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
