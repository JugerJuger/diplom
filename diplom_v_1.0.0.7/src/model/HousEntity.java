package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the houses database table.
 * 
 */
@Entity
@Table(name = "houses")
@NamedQueries({ @NamedQuery(name = "HousEntity.findAll", query = "SELECT h FROM HousEntity h"),
		@NamedQuery(name = "HousEntity.findByUUID", query = "SELECT h FROM HousEntity h WHERE h.uuid = :uuid") })
public class HousEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private String uuid;
	private BigDecimal xPosition;
	private BigDecimal yPosition;
	private List<UserEntity> users;

	public HousEntity() {
	}

	@Id
	@SequenceGenerator(name = "HOUSES_ID_GENERATOR", sequenceName = "HOUSE_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOUSES_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "x_position")
	public BigDecimal getXPosition() {
		return this.xPosition;
	}

	public void setXPosition(BigDecimal xPosition) {
		this.xPosition = xPosition;
	}

	@Column(name = "y_position")
	public BigDecimal getYPosition() {
		return this.yPosition;
	}

	public void setYPosition(BigDecimal yPosition) {
		this.yPosition = yPosition;
	}

	// bi-directional many-to-many association to UserEntity
	@ManyToMany
	@JoinTable(name = "HOUSES_USERS", 
		joinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
	)
	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}