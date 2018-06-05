package com.freseniuskabi.dao;

import java.util.List;

import com.freseniuskabi.models.Paciente;

public interface IPacienteDAO {

	List<Paciente> getAllPacientes();

	Paciente getPacienteById(Long PacienteId);

	void addPaciente(Paciente Paciente);

	void updatePaciente(Long id, Paciente Paciente);

	void deletePaciente(Long PacienteId);

	boolean pacienteExists(String username);

	boolean pacienteExists(Long id);

}
