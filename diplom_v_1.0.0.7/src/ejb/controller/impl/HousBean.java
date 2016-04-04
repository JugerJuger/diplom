package ejb.controller.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.controller.AbstractFacade;
import ejb.controller.local.Hous;
import model.HousEntity;
import model.UserEntity;

/**
 * Session Bean implementation class HousBean
 */
@Stateless
@LocalBean
public class HousBean extends AbstractFacade<HousEntity> implements Hous {

	@PersistenceContext(unitName = "diplom_v_1.0.0.7")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
    public HousBean() {
        super(HousEntity.class);
    }
	@Override
	public HousEntity findByUuid(String uuid) {
		List results = em.createNamedQuery("HousEntity.findByUUID").setParameter("uuid", uuid).getResultList();
		if (!results.isEmpty()) {
			return (HousEntity) results.get(0);
		}
		return null;
	}

}
