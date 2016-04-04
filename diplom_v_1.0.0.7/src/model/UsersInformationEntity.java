package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the users_information database table.
 * 
 */
@Entity
@Table(name="users_information")
@NamedQuery(name="UsersInformationEntity.findAll", query="SELECT u FROM UsersInformationEntity u")
public class UsersInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private Date birthday;
	private String firsName;
	private String lastName;
	private String sex;
	private UserEntity user;

	public UsersInformationEntity() {
	}


	@Id
	@SequenceGenerator(name="USERS_INFORMATION_ID_GENERATOR", sequenceName="USERS_INFORMATION_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_INFORMATION_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Column(name="firs_name")
	public String getFirsName() {
		return this.firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}


	@Column(name="last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	//bi-directional one-to-one association to UserEntity
	@OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}