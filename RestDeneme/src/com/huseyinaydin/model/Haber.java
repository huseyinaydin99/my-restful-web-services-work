package com.huseyinaydin.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Haber {
	private String haberAdi;
	private String haberIcerik;
	
	public Haber() {
		super();
	}
	public Haber(String haberAdi, String haberIcerik) {
		super();
		this.haberAdi = haberAdi;
		this.haberIcerik = haberIcerik;
	}
	public String getHaberAdi() {
		return haberAdi;
	}
	public void setHaberAdi(String haberAdi) {
		this.haberAdi = haberAdi;
	}
	public String getHaberIcerik() {
		return haberIcerik;
	}
	public void setHaberIcerik(String haberIcerik) {
		this.haberIcerik = haberIcerik;
	}
	
	
}
