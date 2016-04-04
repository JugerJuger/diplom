package ejb.controller.local;

import java.util.List;

import javax.ejb.Local;

import model.TemperatureStatisticEntity;
import model.UserEntity;

@Local
public interface TemperatureStatistics {
	void create(TemperatureStatisticEntity entity);

	TemperatureStatisticEntity read(Object id);

	void update(TemperatureStatisticEntity entity);

	void delete(TemperatureStatisticEntity entity);

	List<TemperatureStatisticEntity> findAll();

	List<TemperatureStatisticEntity> findRange(int[] range);
}
