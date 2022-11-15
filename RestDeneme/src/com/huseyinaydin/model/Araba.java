package com.huseyinaydin.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Araba {
	private String arabaAdi;
	private String arabaPlaka;
	public Araba(String arabaAdi, String arabaPlaka) {
		super();
		this.arabaAdi = arabaAdi;
		this.arabaPlaka = arabaPlaka;
	}
	
	public Araba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getArabaAdi() {
		return arabaAdi;
	}
	public void setArabaAdi(String arabaAdi) {
		this.arabaAdi = arabaAdi;
	}
	public String getArabaPlaka() {
		return arabaPlaka;
	}
	public void setArabaPlaka(String arabaPlaka) {
		this.arabaPlaka = arabaPlaka;
	}
	
}
