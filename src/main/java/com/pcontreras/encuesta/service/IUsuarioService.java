package com.pcontreras.encuesta.service;

import java.util.List;

import com.pcontreras.encuesta.model.TipoMusica;
import com.pcontreras.encuesta.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Long> {
	
	public List<TipoMusica> findAllTiposMusicales();
    
	public int cantidad();
}
