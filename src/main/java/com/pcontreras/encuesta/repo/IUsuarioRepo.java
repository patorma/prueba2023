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
	
	//select count(*) as repetidos, tp.estilo_musical 
	//from usuarios u,tipos_musicales as tp where u.tipo_musica_id= tp.id  group by tipo_musica_id;
	 @Query(value = "SELECT count(*) as repetidos,tp.estilo_musical from usuarios u\r\n"
	 		+ "inner join tipos_musicales as tp ON u.tipo_musica_id= tp.id\r\n"
	 		+ " group by U.tipo_musica_id", nativeQuery = true)
	    List<Object[]> obtenerCantidadUsuariosPorTipoMusical();
}
