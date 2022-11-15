package com.huseyinaydin.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huseyinaydin.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = new HashMap<>();
	
	public ProfileService(){
		profiles.put("1", new Profile(1, "Profil 1", "Hüseyin", "Aydın", new Date()));
		profiles.put("2", new Profile(2, "Profil 2", "Ceyda", "Koç", new Date()));
		profiles.put("3", new Profile(3, "Profil 3", "Samet", "Ünlü", new Date()));
		profiles.put("4", new Profile(4, "Profil 4", "Şaban", "Dağ", new Date()));
	}

	public List<Profile> getAllProfile() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfiles(long id) {
		System.out.println(profiles.get(id));
		return profiles.get(String.valueOf(id));
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(String.valueOf(profile.getProfileName()), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty())
			return null;
		profiles.put(String.valueOf(profile.getProfileName()), profile);
		return profile;
	}

	public Profile removeProfile(long id) {
		System.out.println("silinmek için geldi : " + id);
		for (int i = 0; i <= getProfiles().size(); i++) {
			try {
				System.out.println(getProfiles(i).getProfileName());
			} catch (NullPointerException e) {
			}
		}
		return this.profiles.remove(id);
	}

	public Map<String, Profile> getProfiles() {
		return profiles;
	}
}
