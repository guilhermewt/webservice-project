package com.webserviceproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceproject.entities.Usuario;
import com.webserviceproject.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
	@Autowired
	private UsuarioService service;
	
	@RequestMapping()
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findById(@PathVariable long id){
		Usuario user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		Usuario user = service.insert(obj);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@RequestBody Usuario obj, @PathVariable long id){
		Usuario user = service.Update(obj, id);
		return ResponseEntity.ok().body(user);
	}
}
