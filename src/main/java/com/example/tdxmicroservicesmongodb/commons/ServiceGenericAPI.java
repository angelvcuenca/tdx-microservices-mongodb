package com.example.tdxmicroservicesmongodb.commons;

import java.io.Serializable;
import java.util.List;

public interface ServiceGenericAPI<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
}