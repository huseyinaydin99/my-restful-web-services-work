package org.turkeyjug.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.turkeyjug.model.Meslek;
import org.turkeyjug.model.Personel;
import org.turkeyjug.model.PersonelMeslek;
import org.turkeyjug.model.PersonelMeslekData;

@Repository
public class PersonelDAOImpl implements PersonelDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonelDAOImpl.class);

	private SessionFactory sessionFactory;
	Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public String personelEkle(Personel p) {
		session = this.sessionFactory.getCurrentSession();
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Memur");
		meslek.setPersonel(p);
		
		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("İşçi");
		meslek2.setPersonel(p);
		
		
		p.getMesleks().add(meslek);
		p.getMesleks().add(meslek2);
		
		session.save(p);
		session.save(meslek);
		session.save(meslek2);
		
		logger.info("Personel eklendi. Bilgisi: " + p);
		return "listele?faces-redirect=true";
	}
	List<Personel> personels = null;
	@Override
	public List<Personel> personelAra() {
		session = this.sessionFactory.getCurrentSession();
		//List<Personel> personelListesi = session.createQuery("FROM Personel").list();
		personels = session.createCriteria(Personel.class)
				.setFetchMode("mesleks", FetchMode.JOIN)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		
		System.out.println(personels.size());
		for (Personel p : personels) {
			logger.info("Personel Bilgisi: " + p);
			Iterator<Meslek> iterator = p.getMesleks().iterator();
			while (iterator.hasNext()) {
				Meslek meslek = iterator.next();
				System.out.println(p.getAdi() + " " + p.getSoyadi() + " " + meslek.getMeslekAdi());
			}
		}
		return personels;
	}
	
	@Override
	public List<Meslek> getMeslekList(){
		List<Meslek> mesleks = new ArrayList<>();
		for (Personel p : personels) {
			Iterator<Meslek> iterator = p.getMesleks().iterator();
			while (iterator.hasNext()) {
				Meslek meslek = iterator.next();
				mesleks.add(meslek);
			}
		}
		return mesleks;
	}

	@Override
	public List<Personel> personelAra(Personel p) {
		session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Personel P " + " WHERE P.adi    LIKE :personelAdi " + " AND   P.soyadi LIKE :personelSoyadi";
		Query sorgu = session.createQuery(hql);
		sorgu.setString("personelAdi", p.getAdi() + "%");
		sorgu.setString("personelSoyadi", p.getSoyadi() + "%");
		List<Personel> personelListesi2 = sorgu.list();
		for (Personel p2 : personelListesi2) {
			logger.info("Personel Bilgisi: " + p2);
		}
		return personelListesi2;
	}

	@Override
	public String personelDuzenle(Personel p) {
		session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Personel guncellendi. Bilgisi: " + p);
		return "listele?faces-redirect=true";
	}

	@Override
	public String personelSil(Personel p) {
		session = this.sessionFactory.getCurrentSession();
		session.delete(p);
		logger.info("Personel silindi. Bilgisi: " + p);
		return "listele?faces-redirect=true";
	}

}