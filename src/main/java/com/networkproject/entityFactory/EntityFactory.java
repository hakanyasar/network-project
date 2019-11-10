package com.networkproject.entityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface EntityFactory {
	
	EntityManager getEntityManager();
	
	EntityTransaction getEntityTransaction();
}