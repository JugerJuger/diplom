package ejb.controller.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.controller.AbstractFacade;
import ejb.controller.local.UserInformation;
import model.UsersInformationEntity;

/**
 * Session Bean implementation class UserInformationBean
 */
@Stateless
public class UserInformationBean extends AbstractFacade<UsersInformationEntity> implements UserInformation {

	@PersistenceContext(unitName = "diplom_v_1.0.0.7")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
    public UserInformationBean() {
       super(UsersInformationEntity.class);
    }

}
