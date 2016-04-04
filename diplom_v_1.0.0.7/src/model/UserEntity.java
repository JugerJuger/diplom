package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u"),
	@NamedQuery(name="UserEntity.findByUUID", query="SELECT u FROM UserEntity u WHERE u.uuid = :uuid"),
	@NamedQuery(name="UserEntity.findByEmail", query="SELECT u FROM UserEntity u WHERE u.email = :email"),
	@NamedQuery(name="UserEntity.findByPhone", query="SELECT u FROM UserEntity u WHERE u.phone = :phone"),
	@NamedQuery(name="User.findByEmailAndPassword", query="SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password"),
	@NamedQuery(name="User.findByPhoneAndPassword", query="SELECT u FROM UserEntity u WHERE u.phone = :phone AND u.password = :password"),
	@NamedQuery(name="UserEntity.findByEmail", query="SELECT u FROM UserEntity u WHERE u.email = :email")
})
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String email;
	private String password;
	private String phone;
	private String uuid;
	private List<HousEntity> houses;
	private TemperatureStatisticEntity temperatureStatistic;
	private UsersInformationEntity usersInformation;

	public UserEntity() {
	}


	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="USERS_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	//bi-directional many-to-many association to HousEntity
	@ManyToMany(mappedBy="users")
	public List<HousEntity> getHouses() {
		return this.houses;
	}

	public void setHouses(List<HousEntity> houses) {
		this.houses = houses;
	}


	//bi-directional one-to-one association to TemperatureStatisticEntity
	@OneToOne(mappedBy="user", cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
	public TemperatureStatisticEntity getTemperatureStatistic() {
		return this.temperatureStatistic;
	}

	public void setTemperatureStatistic(TemperatureStatisticEntity temperatureStatistic) {
		this.temperatureStatistic = temperatureStatistic;
	}


	//bi-directional one-to-one association to UsersInformationEntity
	@OneToOne(mappedBy="user", cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
	public UsersInformationEntity getUsersInformation() {
		return this.usersInformation;
	}

	public void setUsersInformation(UsersInformationEntity usersInformation) {
		this.usersInformation = usersInformation;
	}

}