package com.example.tdxmicroservicesmongodb.model;

public class DocumentsType {
	private String code;
	private String name;
	
	public DocumentsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DocumentsType(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
