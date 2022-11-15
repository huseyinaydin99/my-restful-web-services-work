package org.turkeyjug.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Mimar Aslan
 */
@ManagedBean(name="personel")
@RequestScoped
public class Personel implements Serializable{

	private static final long serialVersionUID = 1L;


    private int personel_id;
	
	private Set<Meslek> mesleks = new HashSet<>();
	
    private int numarasi;
    private String adi;
    private String soyadi;
    private String cinsiyeti;
    private String eposta;
    private String parolasi;
    private boolean secili;
	
    @Override
	public String toString() {
		return "Personel [adi=" + adi 
				+ ", soyadi=" + soyadi 
				+ ", eposta=" + eposta
				+ ", numarasi=" + numarasi 
				+  ", parolasi=" + parolasi + "]";
	}
    
	
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

	

	public Set<Meslek> getMesleks() {
		return mesleks;
	}


	public void setMesleks(Set<Meslek> mesleks) {
		this.mesleks = mesleks;
	}


	public boolean isSecili() {
		return secili;
	}


	public void setSecili(boolean secili) {
		this.secili = secili;
	}
	
	
}