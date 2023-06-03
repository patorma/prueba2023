package com.pcontreras.encuesta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.pcontreras.encuesta.model.TipoMusica;
import com.pcontreras.encuesta.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Long> {

	@Query("from TipoMusica")
	public List<TipoMusica> findAllTiposMusicales();
	
	@Query(value = "SELECT COUNT(mail) FROM Usuarios",nativeQuery = true)
	public int cantidad();
}
