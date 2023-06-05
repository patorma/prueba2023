package com.pcontreras.encuesta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcontreras.encuesta.model.TipoMusica;

import com.pcontreras.encuesta.model.Usuario;
import com.pcontreras.encuesta.repo.IGenericRepo;
import com.pcontreras.encuesta.repo.IUsuarioRepo;
import com.pcontreras.encuesta.service.IUsuarioService;



@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Long> implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo repo;

	@Override
	protected IGenericRepo<Usuario, Long> getRepo() {
		
		return repo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoMusica> findAllTiposMusicales() {
		
		return repo.findAllTiposMusicales();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) throws Exception {
		
		return repo.findAll(pageable) ;
	}

	@Override
	@Transactional
	public int cantidad() {
		
		return repo.cantidad();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> obtenerCantidadUsuariosPorTipoMusical() {
		
		return repo.obtenerCantidadUsuariosPorTipoMusical();
	}

}
