package com.freseniuskabi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freseniuskabi.models.Paciente;

@Transactional
@Repository
public class PacienteDAO implements IPacienteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Paciente getPacienteById(Long pacienteId) {
		return this.entityManager.find(Paciente.class, pacienteId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getAllPacientes() {
		String hql = "FROM Paciente as p ORDER BY p.id";
		return this.entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addPaciente(Paciente paciente) {

		this.entityManager.persist(paciente);
	}

	@Override
	public void updatePaciente(Long id, Paciente paciente) {
		Paciente p = this.getPacienteById(id);
		p.setUsername(paciente.getUsername());
		p.setPassword(paciente.getPassword());
		this.entityManager.flush();
	}

	@Override
	public void deletePaciente(Long PacienteId) {
		this.entityManager.remove(this.getPacienteById(PacienteId));
	}

	@Override
	public boolean pacienteExists(String username) {
		String hql = "FROM Paciente as p WHERE p.username = ? ";
		int count = this.entityManager.createQuery(hql).setParameter(1, username).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public boolean pacienteExists(Long id) {
		return this.getPacienteById(id) != null;
	}

}