package com.pcontreras.encuesta.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// se define las cosas que son comunes en los escenarios 
public interface ICRUD<T,ID> {
	
	T registrar(T t) throws Exception;
	T modificar (T t) throws Exception;
	List<T> listar()throws Exception;
	T listarPorId (ID id) throws Exception;
	void eliminar(ID id)throws Exception;
	Page<T> findAll(Pageable pageable)throws Exception;

}
