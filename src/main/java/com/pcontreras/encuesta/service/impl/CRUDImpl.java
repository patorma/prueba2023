package com.pcontreras.encuesta.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pcontreras.encuesta.repo.IGenericRepo;
import com.pcontreras.encuesta.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	//necesito que una implmentacion le diga como comportarse
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T registrar(T t) throws Exception {
		
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
	
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
		
	}

}
