package com.freseniuskabi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
// only needed if the table name is different from class
// @Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	@JsonIgnore
	private String password;

	public Paciente(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	// to make hibernate happy or it throws errors
	public Paciente() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [id=").append(this.id).append(", username=").append(this.username).append(", password=")
				.append(this.password).append("]");
		return builder.toString();
	}

}
