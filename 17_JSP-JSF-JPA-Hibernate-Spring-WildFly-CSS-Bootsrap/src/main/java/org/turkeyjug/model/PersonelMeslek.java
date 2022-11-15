package org.turkeyjug.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="personel_meslek")
public class PersonelMeslek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="meslek_id")
	private int meslekId;

	@Column(name="personel_id")
	private int personelId;

	public PersonelMeslek() {
	}

	public int getMeslekId() {
		return this.meslekId;
	}

	public void setMeslekId(int meslekId) {
		this.meslekId = meslekId;
	}

	public int getPersonelId() {
		return this.personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

}