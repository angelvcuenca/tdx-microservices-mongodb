package com.example.tdxmicroservicesmongodb.dao.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tdxmicroservicesmongodb.model.Documents;

public interface DocumentsRepository extends MongoRepository<Documents, String> {

}
