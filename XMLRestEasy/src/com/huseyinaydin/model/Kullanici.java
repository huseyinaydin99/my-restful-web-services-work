package com.huseyinaydin.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Kullanici implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "ID")
	private int kullaniciId;
	
	@XmlElement(name = "ADI")
	private String kullaniciAdi;
	
	@XmlElement(name = "SOYADI")
	private String kullaniciSoyadi;
	
	
	public int getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getKullaniciSoyadi() {
		return kullaniciSoyadi;
	}
	public void setKullaniciSoyadi(String kullaniciSoyadi) {
		this.kullaniciSoyadi = kullaniciSoyadi;
	}
	
	
}
