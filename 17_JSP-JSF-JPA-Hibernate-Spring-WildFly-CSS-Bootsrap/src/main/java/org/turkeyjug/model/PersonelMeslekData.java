package org.turkeyjug.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "personelMeslekData")
@RequestScoped
public class PersonelMeslekData {
	
    private int personel_id;
	
    private int numarasi;
    private String adi;
    private String soyadi;
    private String cinsiyeti;
    private String eposta;
    private String parolasi;
    private boolean secili;
    
	
	public int getPersonel_id() {
		return personel_id;
	}


	public void setPersonel_id(int personel_id) {
		this.personel_id = personel_id;
	}


	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public String getCinsiyeti() {
		return cinsiyeti;
	}
	public void setCinsiyeti(String cinsiyeti) {
		this.cinsiyeti = cinsiyeti;
	}
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public int getNumarasi() {
		return numarasi;
	}
	public void setNumarasi(int numarasi) {
		this.numarasi = numarasi;
	}
	
	public String getParolasi() {
		return parolasi;
	}
	public void setParolasi(String parolasi) {
		this.parolasi = parolasi;
	}

	public boolean isSecili() {
		return secili;
	}

	public void setSecili(boolean secili) {
		this.secili = secili;
	}
	private int meslek_id;
	private String meslekAdi;
	
	public int getMeslek_id() {
		return meslek_id;
	}
	public void setMeslek_id(int meslek_id) {
		this.meslek_id = meslek_id;
	}
	public String getMeslekAdi() {
		return meslekAdi;
	}
	public void setMeslekAdi(String meslekAdi) {
		this.meslekAdi = meslekAdi;
	}
}
