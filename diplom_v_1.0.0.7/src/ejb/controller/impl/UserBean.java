package ejb.controller.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.controller.AbstractFacade;
import ejb.controller.local.User;
import model.UserEntity;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean extends AbstractFacade<UserEntity> implements User {

	@PersistenceContext(unitName = "diplom_v_1.0.0.7")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserBean() {
		super(UserEntity.class);
	}

	@Override
	public UserEntity findByUuid(String uuid) {
		List results = em.createNamedQuery("UserEntity.findByUUID").setParameter("uuid", uuid).getResultList();
		if (!results.isEmpty()) {
			return (UserEntity) results.get(0);
		}
		return null;
	}

	@Override
	public UserEntity findByEmail(String email) {
		List result = em.createNamedQuery("UserEntity.findByEmail").setParameter("email", email).getResultList();
		if (!result.isEmpty())
			return (UserEntity) result.get(0);
		return null;
	}

	@Override
	public UserEntity findByPhone(String phone) {
		List result = em.createNamedQuery("UserEntity.findByPhone").setParameter("phone", phone).getResultList();
		if (!result.isEmpty())
			return (UserEntity) result.get(0);
		return null;
	}

	@Override
	public boolean isPhoneUsed(String phone) {
		List result = em.createNamedQuery("UserEntity.findByPhone").setParameter("phone", phone).getResultList();
		return !result.isEmpty();
	}

	@Override
	public boolean isEmailUsed(String email) {
		List result = em.createNamedQuery("UserEntity.findByEmail").setParameter("email", email).getResultList();
		return !result.isEmpty();
	}

	@Override
	public UserEntity findByEmailAndPassword(String email, String password) {
		List result = em.createNamedQuery("User.findByEmailAndPassword").setParameter("email", email).setParameter("password", password).getResultList();
		if (!result.isEmpty())
			return (UserEntity) result.get(0);
		return null;
	}

	@Override
	public UserEntity findByPhoneAndPassword(String phone, String password) {
		List result = em.createNamedQuery("User.findByPhoneAndPassword").setParameter("phone", phone).setParameter("password", password).getResultList();
		if (!result.isEmpty())
			return (UserEntity) result.get(0);
		return null;
	}
}
