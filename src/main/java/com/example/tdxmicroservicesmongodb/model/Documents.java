package com.example.tdxmicroservicesmongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Documents {
	@Transient
    public static final String SEQUENCE_NAME = "documents_sequence";
	
	@Id
	private String id;
	private Integer number;
	private String expiryDate;
	private Date emissionDate;	
	private DocumentsType documentType;

	
	
	
	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Documents(Integer number, String expiryDate, Date emissionDate, DocumentsType documentType) {
		super();
		
		this.number = number;
		this.expiryDate = expiryDate;
		this.emissionDate = emissionDate;
		this.documentType = documentType;
	}
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	public DocumentsType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentsType documentType) {
		this.documentType = documentType;
	}
	
	
}
