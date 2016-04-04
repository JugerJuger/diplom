package ejb.controller.local;

import java.util.List;

import javax.ejb.Local;

import ejb.controller.utilize.UUIDComparator;
import model.HousEntity;
import model.UserEntity;

@Local
public interface Hous  extends UUIDComparator<HousEntity>{
	void create(HousEntity entity);

	HousEntity read(Object id);

	void update(HousEntity entity);

	void delete(HousEntity entity);

	List<HousEntity> findAll();

	List<HousEntity> findRange(int[] range);
	
	HousEntity findByUuid(String uuid);
	
}
