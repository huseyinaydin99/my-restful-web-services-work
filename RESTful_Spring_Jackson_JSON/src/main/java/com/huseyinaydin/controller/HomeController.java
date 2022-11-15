package com.huseyinaydin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huseyinaydin.model.Personel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	static Set<Personel> personeller;
	static {
		personeller = new HashSet<Personel>();
		Personel personel = null;
		for (int i = 0; i < 10; i++) {
			personel = new Personel(i, "Personel : " + String.valueOf(i));
			personeller.add(personel);
		}
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("serverTime", "ABC");

		return "home";
	}

	@RequestMapping(value = "/listele", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Set<Personel> getPersonelListesi() {

		return personeller;
	}

	@RequestMapping(value = "/listele/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Personel getPersonelId(@PathVariable("id") int id) {
		Iterator<Personel> iterator = personeller.iterator();
		while (iterator.hasNext()) {
			Personel personel = (Personel) iterator.next();
			if (personel.getPersonelId() == id) {
				return personel;
			} else {

			}
		}
		return null;

	}

	@RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Set<Personel> deletePersonel(@PathVariable("id") int id) {

		Iterator<Personel> iterator = personeller.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			Personel personel = (Personel) iterator.next();

			if (i == id) {
				personeller.remove(personel);
				break;
			}
			i++;
		}

		return personeller;
	}
	
	@RequestMapping(value = "/ekle", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json",consumes = "application/json")
	@ResponseBody
	public Set<Personel> deletePersonel(@RequestBody Personel personel) {
		personeller.add(personel);
		return personeller;
	}
	
	@RequestMapping(value = "/guncelle/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json",consumes = "application/json")
	@ResponseBody
	public Set<Personel> updatePersonel(@RequestBody Personel personel,@PathVariable("id") int id) {
		Iterator<Personel> iterator = personeller.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			Personel personeli = (Personel) iterator.next();

			if (i == id) {
				personeli.setPersonelId(id);
				personeli.setPersonelAdi(personel.getPersonelAdi());
				break;
			}
			i++;
		}
		return personeller;
	}
}
