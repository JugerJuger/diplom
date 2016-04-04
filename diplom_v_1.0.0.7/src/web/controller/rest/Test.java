package web.controller.rest;

import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.controller.local.User;
import model.UserEntity;
import web.controller.rest.json.UserJSON;

@Path("path")
public class Test {

	@EJB
	User user;

	@GET
	@Path("method")
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello() {
		return user.findAll().get(0).toString();
	}

	@POST
	@Path("getus")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserDataByUUID(UserJSON uuid) {
//		UserEntity userEntity = new UserEntity();
		
		System.out.println(uuid.toString());
		
//		userEntity.setEmail("jhbjhkbjhjkb");
//		userEntity.setPhone("kjlbfskdfknbf");
//		userEntity.setPassword("sg");
//		userEntity.setUuid(UUID.randomUUID().toString());
//		
		
//		user.create(userEntity);
		
		
		
		
		
		
		
		
		
		
		
		
		return Response.status(200).entity("Hello").build();
	}

}
