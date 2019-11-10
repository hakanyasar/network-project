package com.networkproject.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.Router;
import com.networkproject.queries.RouterQueries;
import com.networkproject.repository.RouterRepository;

public class RouterRepositoryImpl implements RouterRepository{

	
	private EntityFactory entityFactory = new EntityFactoryImpl();

	private EntityManager entityManager = entityFactory.getEntityManager();

	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	
	@Override
	public Router saveRouter(final Router router) {
		
		try {

			this.transaction.begin();

			this.entityManager.persist(router);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return router;
	}

	@Override
	public Router updateRouter(final Router router) {

		try {

			this.transaction.begin();

			this.entityManager.merge(router);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return router;
	}

	@Override
	public Router deleteRouter(Router router) {

		try {

			if (this.entityManager.contains(router)) {
				this.entityManager.remove(router);
			} else {
				Router tempRouter = this.findRouterById(router.getRouterId());
				this.entityManager.remove(tempRouter);
			}

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}

		return router;
	}

	@Override
	public List<Router> findAllRouters() {

		List<Router> routers = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findAllRouters, Router.class);

			routers = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routers;
		
	}

	@Override
	public Router findRouterById(final int routerId) {

		Router router = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterById, Router.class);
			typedQuery.setParameter("routerId", routerId);
			
			router = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return router;
	}

	@Override
	public List<Router> findRoutersByUnitId(final int unitId) {

		List<Router> routers = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRoutersByUnitId, Router.class);
			typedQuery.setParameter("unitId", unitId);
			
			routers = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routers;
	}

	@Override
	public List<Router> findRoutersByProvinceId(final int provinceId) {

		List<Router> routers = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRoutersByProvinceId, Router.class);
			typedQuery.setParameter("provinceId", provinceId);
			
			routers = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routers;
	}

	@Override
	public Router findRouterByTextId(final int textId) {

		
		Router router = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterByTextId, Router.class);
			typedQuery.setParameter("textId", textId);
			
			router = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return router;
		
	}

	@Override
	public List<String> findAllRouterBrands() {
		
		List<String> routerBrands = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(RouterQueries.findAllRouterBrands, String.class);

			routerBrands = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routerBrands;
	}

	@Override
	public ArrayList<String> findAllRouterModels() {
		
		ArrayList<String> routerModels = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(RouterQueries.findAllRouterModels, String.class);

			routerModels = (ArrayList<String>) typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routerModels;
	}

	@Override
	public Router findRouterByRouterBrandAndRouterModel(String routerBrand, String routerModel) {

		Router router = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterByRouterBrandAndRouterModel, Router.class);
			typedQuery.setParameter("routerBrand", routerBrand);
			typedQuery.setParameter("routerModel", routerModel);
			
			router = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return router;

	}

	@Override
	public ArrayList<String> findRouterBrandsByProvinceIdAndUnitId(int provinceId, int unitId) {

		ArrayList<String> routerBrands = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterBrandsByProvinceIdAndUnitId, String.class);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			
			routerBrands = (ArrayList<String>) typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routerBrands;
	}

	@Override
	public Router findRouterByRouterBrandName(String routerBrand) {

		Router router = null;

		try {

			TypedQuery<Router> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterByRouterBrandName, Router.class);
			typedQuery.setParameter("routerBrand", routerBrand);
			
			router = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return router;
	}

	@Override
	public ArrayList<String> findRouterModelsByProvinceIdUnitIdRouterId(int provinceId, int unitId, int routerId) {

		ArrayList<String> routerModels = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(RouterQueries.findRouterModelsByProvinceIdUnitIdRouterId, String.class);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("routerId", routerId);
			
			routerModels = (ArrayList<String>) typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return routerModels;
	}

}
