package com.mongo.dao.ogm.em;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
@Stateless
public class EntityManagerFactory {
	@PersistenceContext(unitName = "hike-PU-JTA")
	private EntityManager entityManager;
 
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return entityManager;
	}
}