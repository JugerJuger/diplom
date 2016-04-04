package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the temperature_statistics database table.
 * 
 */
@Entity
@Table(name="temperature_statistics")
@NamedQuery(name="TemperatureStatisticEntity.findAll", query="SELECT t FROM TemperatureStatisticEntity t")
public class TemperatureStatisticEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private BigDecimal maxTemperatureValue;
	private BigDecimal minTemperatureValue;
	private BigDecimal optimalTemperatureValue;
	private UserEntity user;

	public TemperatureStatisticEntity() {
	}


	@Id
	@SequenceGenerator(name="TEMPERATURE_STATISTICS_ID_GENERATOR", sequenceName="TEMPERATURE_STATISTICS_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMPERATURE_STATISTICS_ID_GENERATOR")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Column(name="max_temperature_value")
	public BigDecimal getMaxTemperatureValue() {
		return this.maxTemperatureValue;
	}

	public void setMaxTemperatureValue(BigDecimal maxTemperatureValue) {
		this.maxTemperatureValue = maxTemperatureValue;
	}


	@Column(name="min_temperature_value")
	public BigDecimal getMinTemperatureValue() {
		return this.minTemperatureValue;
	}

	public void setMinTemperatureValue(BigDecimal minTemperatureValue) {
		this.minTemperatureValue = minTemperatureValue;
	}


	@Column(name="optimal_temperature_value")
	public BigDecimal getOptimalTemperatureValue() {
		return this.optimalTemperatureValue;
	}

	public void setOptimalTemperatureValue(BigDecimal optimalTemperatureValue) {
		this.optimalTemperatureValue = optimalTemperatureValue;
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