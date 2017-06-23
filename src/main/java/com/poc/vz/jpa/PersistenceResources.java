package com.poc.vz.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 */

/**
 * @author ranjit.soni
 *
 */
public class PersistenceResources {

	@PersistenceContext(unitName="vz")
	private EntityManager entityManager;
	
	@Produces
    private EntityManager transactionScopedEntityManager() {
        return this.entityManager;
    }
}
