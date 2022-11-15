package com.huseyinaydin.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Kullanici {
	private int kullaniciId;
	private String kullaniciAdi;
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
