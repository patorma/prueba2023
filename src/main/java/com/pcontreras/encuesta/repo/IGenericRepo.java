package com.pcontreras.encuesta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//Se crea interfaz generica para hacer uso de los métodos de JpaRewpository por parte de las inreface relacionadas 
//a las entidades
@NoRepositoryBean
public interface IGenericRepo<T,ID> extends JpaRepository<T, ID> {

}
