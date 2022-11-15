package com.huseyinaydin.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.huseyinaydin.messenger.model.Profile;
import com.huseyinaydin.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService = new ProfileService();
	
	
	@GET
	public List<Profile> getProfile() {
		for (int i = 0; i <= profileService.getProfiles().size(); i++) {
			try {
				System.out.println(profileService.getProfiles(i).getProfileName());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		return profileService.getAllProfile();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}

	/*
	 * @GET
	 * 
	 * @Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Message
	 * getMessage(@PathParam("messageId") long messageId){ return
	 * messageService.getMessages(messageId); }
	 */

	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") long profileId) {
		System.out.println("geldi");
		for (int i = 0; i <= profileService.getProfiles().size(); i++) {
			try {
				System.out.println(profileService.getProfiles(i).getProfileName());
			} catch (NullPointerException e) {}
		}
		System.out.println("------------------");
		return profileService.getProfiles(profileId);
	}

	/*
	 * @POST //@Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public String testPost(){ return
	 * "test post.!"; }
	 */

	@POST
	// @Path("/{messageId}")
	public Profile addProfile(Profile profile) {
		System.out.println("eklendi");
		return profileService.addProfile(profile);
	}

	@PUT
	@Path("/{messageId}")
	public Profile updateMessage(@PathParam("messageId") long id, Profile profile) {
		System.out.println("update");
		profile.setId(id);
		System.out.println(profile.getProfileName());
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{messageId}")
	public Profile deleteMessage(@PathParam("messageId") long id) {
		System.out.println("delete");
		System.out.println(id);
		return profileService.removeProfile(id);
	}
}
