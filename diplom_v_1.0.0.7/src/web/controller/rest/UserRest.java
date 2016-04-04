package web.controller.rest;

import java.math.BigDecimal;
import java.sql.Date;
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
import model.HousEntity;
import model.TemperatureStatisticEntity;
import model.UserEntity;
import model.UsersInformationEntity;
import web.controller.rest.json.LogInJson;
import web.controller.rest.json.UserJSON;
import web.controller.utilize.Validator;

@Path("user")
public class UserRest {

	@EJB
	User user;

	@GET
	@Path("method")
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello() {
		return "Hello";
	}
	
	
	
	@POST
	@Path("getuserdatabyuuid")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserByUUID(String uuid) {
		UserEntity userEntity = user.findByUuid(uuid);
		if (userEntity == null)
			return "Error";//Response.status(404).entity("User non found.").build();
		else {
			return new UserJSON().toJSON(userEntity);//Response.status(200).entity(json.toString()).build();
		}
	}

	@POST
	@Path("getuserbyuuid")
	@Consumes("text/plain")
	public Response getUserDataByUUID(String uuid) {
		UserEntity userEntity = user.findByUuid(uuid);
		StringBuilder sb = new StringBuilder();
		sb.append(userEntity.getEmail());
		if (userEntity != null)
			return Response.status(200).entity(sb.toString()).build();
		else
			return Response.status(404).entity("Bad response.").build();
	}

	@POST
	@Path("getus")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserDataByUUID(UserJSON json) {
		String uuid = getUUID();
		UserEntity userEntity = new UserEntity();
		UsersInformationEntity usersInformationEntity = new UsersInformationEntity();
		TemperatureStatisticEntity temperatureStatisticEntity = new TemperatureStatisticEntity();
		if (user.isPhoneUsed(json.getPhone())) {
			return Response.status(400).entity("User with this phone is exist!!!").build();
		} else if (user.isEmailUsed(json.getEmail())) {
			return Response.status(400).entity("User with this email is exist!!!").build();
		} else {
			createUser(userEntity, usersInformationEntity, temperatureStatisticEntity, uuid, json);
			user.create(userEntity);
			return Response.status(200).entity(uuid).build();
		}

	}

	@POST
	@Path("logIn")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logIn(LogInJson json) {
		UserEntity userEntity = null;
		if (Validator.validation(json.getLogin(), Validator.EMAIL_REGEX) && user.isEmailUsed(json.getLogin())) {
			userEntity = user.findByEmailAndPassword(json.getLogin(), json.getPass());
			return Response.status(200).entity(userEntity.getUuid()).build();
		} else if (Validator.validation(json.getLogin(), Validator.PHONE_REGEX) && user.isPhoneUsed(json.getLogin())) {
			userEntity = user.findByPhoneAndPassword(json.getLogin(), json.getPass());
			return Response.status(200).entity(userEntity.getUuid()).build();
		} else
			return Response.status(400).entity("No user like you try confirm\n You use illegal login or password!!!")
					.build();
	}

	private String getUUID() {
		String uuid = UUID.randomUUID().toString();
		if (user.findByUuid(uuid) != null)
			uuid = UUID.randomUUID().toString();
		return uuid;
	}

	private void createUser(UserEntity userEntity, UsersInformationEntity usersInformationEntity,
			TemperatureStatisticEntity temperatureStatisticEntity, String uuid, UserJSON json) {

		userEntity.setEmail(json.getEmail());
		userEntity.setPhone(json.getPhone());
		userEntity.setPassword(json.getPassword());
		userEntity.setUuid(uuid);

		usersInformationEntity.setFirsName(json.getFirsName());
		usersInformationEntity.setLastName(json.getLastName());
		usersInformationEntity.setSex(json.getSex());
		if (!json.getBirthday().equals(""))
			usersInformationEntity.setBirthday(Date.valueOf(json.getBirthday()));
		if (!json.getMax().equals(""))
			temperatureStatisticEntity.setMaxTemperatureValue(new BigDecimal(json.getMax()));
		else
			temperatureStatisticEntity.setMaxTemperatureValue(new BigDecimal("0"));
		if (!json.getMin().equals(""))
			temperatureStatisticEntity.setMinTemperatureValue(new BigDecimal(json.getMin()));
		else
			temperatureStatisticEntity.setMinTemperatureValue(new BigDecimal("0"));
		if (!json.getOpt().equals(""))
			temperatureStatisticEntity.setOptimalTemperatureValue(new BigDecimal(json.getOpt()));
		else
			temperatureStatisticEntity.setOptimalTemperatureValue(new BigDecimal("0"));
		temperatureStatisticEntity.setUser(userEntity);
		usersInformationEntity.setUser(userEntity);
		userEntity.setTemperatureStatistic(temperatureStatisticEntity);
		userEntity.setUsersInformation(usersInformationEntity);

	}

}
