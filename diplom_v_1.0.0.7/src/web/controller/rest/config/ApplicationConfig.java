package web.controller.rest.config;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import model.HousEntity;
import web.controller.rest.HousRest;
import web.controller.rest.Test;
import web.controller.rest.UserRest;



@ApplicationPath("web")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Method contains java classes which are included to ReST service
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(Test.class);
		resources.add(UserRest.class);
		resources.add(HousRest.class);

	}
}
