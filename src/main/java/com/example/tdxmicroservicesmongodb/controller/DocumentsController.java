package com.example.tdxmicroservicesmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.tdxmicroservicesmongodb.exceptions.ResourceNotFoundException;
import com.example.tdxmicroservicesmongodb.model.Documents;
import com.example.tdxmicroservicesmongodb.model.DocumentsType;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE,
		RequestMethod.PUT })
public class DocumentsController {
	@Autowired
	private DocumentsRepository documentsRepository;

	// Listar todos los documentos
	@GetMapping(value = "/allDoc")
	public List<Documents> getAll() {
		return this.documentsRepository.findAll();
	}

	// Busca un documento en especifico
	
	@GetMapping("/findIdDoc/{id}")
	public Documents documentsById(@PathVariable("id") String id) {
		return this.documentsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe un Documento con el _id: " + id));
	}

	// Crear un nuevo documento
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createDoc")
	public Documents create(@Validated @RequestBody Documents documents) {
		return documentsRepository.insert(documents);
	}

	// Actualizar documento
	@PutMapping(value = "/updateDoc/{id}")
	public Documents update(@PathVariable String id, @Validated @RequestBody Documents documents) {

		Documents doc = this.documentsRepository
				.findById(id)				
				.orElseThrow(() -> new ResourceNotFoundException("No existe un Documento con el _id:" + id));
		doc.setNumber(documents.getNumber());
		doc.setExpiryDate(documents.getExpiryDate());
		doc.setEmissionDate(documents.getEmissionDate());
		doc.setDocumentType(documents.getDocumentType());

		return this.documentsRepository.save(doc);

	}

	// Eliminar Documento
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/deleteDoc/{id}")
	public void delete(@PathVariable String id) {
		Documents documents = documentsRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe un Documento con el _id:" + id));
		documentsRepository.deleteById(id);
	}
	
	/*
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Documents> deleteUser(@PathVariable("id") long userId) {
		Documents existingUser = this.documentsRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		this.documentsRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}*/

}
