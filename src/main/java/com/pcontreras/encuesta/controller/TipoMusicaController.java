package com.pcontreras.encuesta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcontreras.encuesta.model.TipoMusica;

import com.pcontreras.encuesta.service.ITipoMusicaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:4200" })
@RequestMapping("/api")
public class TipoMusicaController {
	
	@Autowired
	private ITipoMusicaService tipoMusicaService;
	
	
	@GetMapping("/estilosMusicales")
	public List<TipoMusica> listar() throws Exception{
		return tipoMusicaService.listar();
	}
	
	@GetMapping("/estilosMusicales/page/{page}")
	public Page<TipoMusica> index(@PathVariable Integer page) throws Exception{
		Pageable pageable = PageRequest.of(page, 4);
		return tipoMusicaService.findAll(pageable);
	}
	
	@GetMapping("/estilosMusicales/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) throws Exception{
		
		TipoMusica tipoMusica = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoMusica = tipoMusicaService.listarPorId(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(tipoMusica == null) {
			response.put("mensaje", "El tipode música con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TipoMusica>(tipoMusica,HttpStatus.OK);
	}
	
	@PostMapping("/estilosMusicales")
	public ResponseEntity<?> create(@Valid @RequestBody TipoMusica tipoMusica,BindingResult result) throws Exception{
		// es el nuevo tipoMusica creado
		//se inicializa
		TipoMusica tipoMusicaNew = null;
		Map<String, Object> response =new HashMap<>();
		
		// se valida si contiene errores el objeto 
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					     .stream()
					     .map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())
					     .collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		}
		try {
			tipoMusicaNew = tipoMusicaService.registrar(tipoMusica);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de música ha sido creado éxito! ");
		response.put("tipoMusica", tipoMusicaNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/estilosMusicales/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody TipoMusica tipoMusica,BindingResult result,@PathVariable Long id) throws Exception{
		
		//se obtiene el tipoMusica que se quiere modificar
		TipoMusica tipoMusicaActual = tipoMusicaService.listarPorId(id);
		
		//TipoMusica ya actualizado
		TipoMusica tipoMusicaUpdated = null;
		

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			// se debe obtener los mensajes de errror de cada campo 
			// y convertir estos en una lista de errores de tipo string
			
			// se debe convertir esta lista de fielderrors en String
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())// muy parecido  al operador map en angular (rxjs), mismo concepto!
					.collect(Collectors.toList());// ahora podemos convertir de regreso el stream  aun tipo List
			response.put("errors", errors);
			// se responde con un responseentity con listados de error
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
			// en lo anterior se recibe un field errors y lo convertimos a string
		}
		
		if(tipoMusicaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el tipo de música con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del tip de música actual con los datos del estilo musical que te envian
			tipoMusicaActual.setEstiloMusical(tipoMusica.getEstiloMusical());
	
			
			tipoMusicaUpdated = tipoMusicaService.registrar(tipoMusicaActual);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar al tipo de música en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		response.put("mensaje", "El tipo de música ha sido actualizado con éxito!");
		response.put("tipoMusica", tipoMusicaUpdated);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/estilosMusicales/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoMusicaService.eliminar(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar al tipo de música de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El tipo de música fue eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
}
