package web.controller.rest.json;

import model.UserEntity;

public class LogInJson {

	private String login;
	private String pass;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toJSON(){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"login\":\"").append(login).append("\",");
		out.append("\"pass\":\"").append(pass).append("\"}");
		return out.toString();
	}
	
	public String toJSON(UserEntity userEntity){
		StringBuilder out = new StringBuilder();
		out.append("{");
		out.append("\"login\":\"").append(userEntity.getEmail()).append("\",");
		out.append("\"pass\":\"").append(userEntity.getPassword()).append("\"}");
		return out.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("'logIn':{");
		out.append("'login':'").append(login).append("',");
		out.append("'pass':'").append(pass).append("'}");
		return out.toString();
	}
}
