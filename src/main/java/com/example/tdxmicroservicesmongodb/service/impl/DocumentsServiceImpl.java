package com.example.tdxmicroservicesmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.tdxmicroservicesmongodb.commons.ServiceGenericImpl;
import com.example.tdxmicroservicesmongodb.dao.api.DocumentsRepository;
import com.example.tdxmicroservicesmongodb.model.Documents;
import com.example.tdxmicroservicesmongodb.service.DocumentsServiceApi;

@Service
public class DocumentsServiceImpl extends ServiceGenericImpl<Documents, Long> implements DocumentsServiceApi {
	
	@Autowired
	private DocumentsRepository documentsServiceApi;
	
	@Override
	public CrudRepository<Documents, Long> getDao() {
		return documentsServiceApi;
	}

}
