package ejb.controller.local;

import java.util.List;

import javax.ejb.Local;

import model.UserEntity;
import model.UsersInformationEntity;

@Local
public interface UserInformation {
	void create(UsersInformationEntity entity);

	UsersInformationEntity read(Object id);

	void update(UsersInformationEntity entity);

	void delete(UsersInformationEntity entity);

	List<UsersInformationEntity> findAll();

	List<UsersInformationEntity> findRange(int[] range);
}
