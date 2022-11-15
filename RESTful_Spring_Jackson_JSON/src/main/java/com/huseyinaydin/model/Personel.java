package com.huseyinaydin.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Personel {
	private int personelId;
	private String personelAdi;
	
	
	
	public Personel(int personelId, String personelAdi) {
		super();
		this.personelId = personelId;
		this.personelAdi = personelAdi;
	}
	
	
	public Personel() {
		super();
	}


	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	
	
}
