package com.example.tdxmicroservicesmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdxmicroservicesmongodb.dao.api.DocumentsRepository;
import com.example.tdxmicroservicesmongodb.model.Documents;


@RestController
@RequestMapping(value="/api/v1")
@CrossOrigin(origins =  "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
public class DocumentsController {
	@Autowired
	private DocumentsRepository documentsRepository;
	
	//Listar todos los documentos
	@GetMapping(value ="/all")
	public List<Documents> getAll(){
		return documentsRepository.findAll();
	}
	
	//Crear un nuevo documento
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/create")
	public Documents create(@Validated @RequestBody Documents documents) {
		return documentsRepository.insert(documents);		
	}
	
	//Actualizar documento
	@PutMapping(value = "/update/{id}")
	public Documents update(@PathVariable Long id,@Validated @RequestBody Documents documents) {
		 return documentsRepository.save(documents);							
	}
	
	//Eliminar Documento
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		Documents documents = documentsRepository
				.findById(id)
				.orElseThrow(RuntimeException::new);
		documentsRepository.delete(documents);
	}

}
