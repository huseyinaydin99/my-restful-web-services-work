package org.turkeyjug.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Meslek {
	private int meslek_id;
	private String meslekAdi;
	private Personel personel;
	
	
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
	public Personel getPersonel() {
		return personel;
	}
	public void setPersonel(Personel personel) {
		this.personel = personel;
	}
	
	
}
