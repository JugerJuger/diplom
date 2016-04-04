package web.controller.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.controller.local.Hous;
import ejb.controller.local.User;
import model.HousEntity;
import model.UserEntity;
import web.controller.rest.json.HousJSON;


@Path("hous")
public class HousRest {
	
	@EJB
	User user;
	@EJB
	Hous hous;
	
	@GET
	@Path("method")
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello() {
		return "Hello";
	}
	
	
	@POST
	@Path("sethous")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setHous(HousJSON json){
		UserEntity userEntity = user.findByUuid(json.getUserUuid());
		HousEntity housEntity = null;
		if(userEntity != null){
			if(json.getUuid().equals("") || json.getUuid() == null){
				housEntity = new HousEntity();
				housEntity.setUuid(UUID.randomUUID().toString());
				housEntity.setAddress(json.getAddress());
				housEntity.setXPosition(new BigDecimal(json.getxPosition()));
				housEntity.setYPosition(new BigDecimal(json.getyPosition()));
				userEntity.getHouses().add(housEntity);
				hous.create(housEntity);
				housEntity.getUsers().add(userEntity);
				hous.update(housEntity);
				
			} else {
				housEntity = hous.findByUuid(json.getUuid());
				userEntity.getHouses().add(housEntity);
				housEntity.getUsers().add(userEntity);
				hous.update(housEntity);
			}
		}
		
		return HousJSON.toJSON(userEntity);
//		return Response.status(200).entity(HousJSON.toJSON(userEntity)).build();
	}
	
	@POST
	@Path("gethouses")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public String setHous(String uuid){
		UserEntity userEntity = user.findByUuid(uuid);
		String out = HousJSON.toJSON(userEntity.getHouses()); 
		System.out.println(userEntity.getHouses().size());
		System.out.println(out);
		if(userEntity != null)
			return out;
		else
			return "Error";
	}
	
	

}
