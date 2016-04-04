package ejb.controller.local;

import java.util.List;

import javax.ejb.Local;

import ejb.controller.utilize.UUIDComparator;
import model.UserEntity;

@Local
public interface User extends UUIDComparator<UserEntity>{
	
	void create(UserEntity entity);

	UserEntity read(Object id);

	void update(UserEntity entity);

	void delete(UserEntity entity);

	List<UserEntity> findAll();

	List<UserEntity> findRange(int[] range);

	UserEntity findByUuid(String uuid);

	UserEntity findByEmail(String email);

	UserEntity findByPhone(String phone);
	
	UserEntity findByEmailAndPassword(String email, String password);

	UserEntity findByPhoneAndPassword(String phone, String password);
	
	boolean isPhoneUsed(String phone);
	
	boolean isEmailUsed(String email);
	
	
	
}
