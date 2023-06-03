package com.pcontreras.encuesta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tipos_musicales")
@Data
public class TipoMusica {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private  Long id;
	
	@Column(name = "estilo_musical")
	@NotEmpty
	@Size(min = 3,max = 50)
	private String estiloMusical;

}
