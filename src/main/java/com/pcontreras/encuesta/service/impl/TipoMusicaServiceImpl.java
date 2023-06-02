package com.pcontreras.encuesta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pcontreras.encuesta.model.TipoMusica;
import com.pcontreras.encuesta.repo.IGenericRepo;
import com.pcontreras.encuesta.repo.ITipoMusicaRepo;
import com.pcontreras.encuesta.service.ITipoMusicaService;

@Service
public class TipoMusicaServiceImpl extends CRUDImpl<TipoMusica, Long> implements ITipoMusicaService{
	
	@Autowired
	private ITipoMusicaRepo repo; //instancia que gestiona sping para logica de acceso de datos


	@Override
	protected IGenericRepo<TipoMusica, Long> getRepo() {
		
		return repo;
	}


	@Override
	public Page<TipoMusica> findAll(Pageable pageable) throws Exception {
		
		return repo.findAll(pageable);
	}

}
