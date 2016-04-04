package ejb.controller.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.controller.AbstractFacade;
import ejb.controller.local.TemperatureStatistics;
import model.TemperatureStatisticEntity;

/**
 * Session Bean implementation class TemperatureStatisticsBean
 */
@Stateless
public class TemperatureStatisticsBean extends AbstractFacade<TemperatureStatisticEntity> implements TemperatureStatistics {

	@PersistenceContext(unitName = "diplom_v_1.0.0.7")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
    public TemperatureStatisticsBean() {
       super(TemperatureStatisticEntity.class);
    }

}
