package com.pcontreras.encuesta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@NotEmpty
	@Column(nullable = false,unique = true)
	private String mail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull(message = "El tipo de musica no puede estar vacio")
	@JoinColumn(name = "tipo_musica_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private TipoMusica tipoMusica;
}
