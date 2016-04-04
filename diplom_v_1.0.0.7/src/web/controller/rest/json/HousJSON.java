package web.controller.rest.json;

import java.util.List;

import model.HousEntity;
import model.UserEntity;

public class HousJSON {
	
	private String address;
	private String xPosition;
	private String yPosition;
	private String uuid;
	private String userUuid;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getxPosition() {
		return xPosition;
	}
	public void setxPosition(String xPosition) {
		this.xPosition = xPosition;
	}
	public String getyPosition() {
		return yPosition;
	}
	public void setyPosition(String yPosition) {
		this.yPosition = yPosition;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	
	public String toJSON(){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"uuid\":\"").append(uuid).append("\",");
		out.append("\"address\":\"").append(address).append("\",");
		out.append("\"xPosition\":\"").append(xPosition).append("\",");
		out.append("\"yPosition\":\"").append(yPosition).append("\",");
		out.append("\"userUuid\":\"").append(userUuid).append("\"}");
		return out.toString();
	}
	
	public String toJSON(HousEntity housEntity){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"uuid\":\"").append(housEntity.getUuid()).append("\",");
		out.append("\"address\":\"").append(housEntity.getAddress()).append("\",");
		out.append("\"xPosition\":\"").append(housEntity.getXPosition()).append("\",");
		out.append("\"yPosition\":\"").append(housEntity.getYPosition()).append("\",");
		out.append("\"userUuid\":\"").append(housEntity.getUsers().get(0).getUuid()).append("\"}");
		return out.toString();
	}
	
	public String toJSON(HousEntity housEntity, String userUuid){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"uuid\":\"").append(housEntity.getUuid()).append("\",");
		out.append("\"address\":\"").append(housEntity.getAddress()).append("\",");
		out.append("\"xPosition\":\"").append(housEntity.getXPosition()).append("\",");
		out.append("\"yPosition\":\"").append(housEntity.getYPosition()).append("\",");
		out.append("\"userUuid\":\"").append(userUuid).append("\"}");
		return out.toString();
	}
	
	
	public static String toJSON(UserEntity userEntity){
		return toJSON(userEntity.getHouses());
	}
	
	public static String toJSON(List<HousEntity> list){
		if(list.isEmpty())
			return "[]";
		StringBuilder out = new StringBuilder();
		out.append("[");
		for (HousEntity housEntity : list) {
			out.append("{");
			out.append("\"uuid\":\"").append(housEntity.getUuid()).append("\",");
			out.append("\"address\":\"").append(housEntity.getAddress()).append("\",");
			out.append("\"xPosition\":\"").append(housEntity.getXPosition()).append("\",");
			out.append("\"yPosition\":\"").append(housEntity.getYPosition()).append("\"},");
		}
//		out.append("]");
		out.replace(out.length()-1, out.length(),  "]");
		return out.toString();
	}
	
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("'hous':{");
		out.append("'uuid':'").append(uuid).append("',");
		out.append("'address':'").append(address).append("',");
		out.append("'xPosition':'").append(xPosition).append("',");
		out.append("'yPosition':'").append(yPosition).append("',");
		out.append("'userUuid':'").append(userUuid).append("'}");
		return out.toString();
	}
	
	
	
}
