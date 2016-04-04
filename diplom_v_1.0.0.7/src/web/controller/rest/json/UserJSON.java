package web.controller.rest.json;

import java.util.UUID;

import model.UserEntity;

public class UserJSON {
	
	private String email;
	private String password;
	private String phone;
	private String uuid;
	
	private String birthday;
	private String firsName;
	private String lastName;
	private String sex;
	
	private String max;
	private String min;
	private String opt;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
	public String toJSON(){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"uuid\":\"").append(uuid).append("\",");
		out.append("\"email\":\"").append(email).append("\",");
		out.append("\"phone\":\"").append(phone).append("\",");
		out.append("\"password\":\"").append(password).append("\",");
		out.append("\"firsName\":\"").append(firsName).append("\",");
		out.append("\"lastName\":\"").append(lastName).append("\",");
		out.append("\"sex\":\"").append(sex).append("\",");
		out.append("\"birthday\":\"").append(birthday).append("\",");
		out.append("\"max\":\"").append(max).append("\",");
		out.append("\"min\":\"").append(min).append("\",");
		out.append("\"opt\":\"").append(opt).append("\"}");
		return out.toString();
	}
	
	public String toJSON(UserEntity userEntity){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"uuid\":\"").append(userEntity.getUuid()).append("\",");
		out.append("\"email\":\"").append(userEntity.getEmail()).append("\",");
		out.append("\"phone\":\"").append(userEntity.getPhone()).append("\",");
		out.append("\"firsName\":\"").append(userEntity.getUsersInformation().getFirsName()).append("\",");
		out.append("\"lastName\":\"").append(userEntity.getUsersInformation().getLastName()).append("\",");
		out.append("\"max\":\"").append(userEntity.getTemperatureStatistic().getMaxTemperatureValue()).append("\",");
		out.append("\"min\":\"").append(userEntity.getTemperatureStatistic().getMinTemperatureValue()).append("\",");
		out.append("\"opt\":\"").append(userEntity.getTemperatureStatistic().getOptimalTemperatureValue()).append("\"}");
		return out.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("'user':{");
		out.append("'uuid':'").append(uuid).append("',");
		out.append("'email':'").append(email).append("',");
		out.append("'phone':'").append(phone).append("',");
		out.append("'password':'").append(password).append("',");
		out.append("'firsName':'").append(firsName).append("',");
		out.append("'lastName':'").append(lastName).append("',");
		out.append("'sex':'").append(sex).append("',");
		out.append("'birthday':'").append(birthday).append("',");
		out.append("'max':'").append(max).append("',");
		out.append("'min':'").append(min).append("',");
		out.append("'opt':'").append(opt).append("'}");
		return out.toString();
	}
}
