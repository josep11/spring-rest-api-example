package com.freseniuskabi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freseniuskabi.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
