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
import com.networkproject.model.Unit;
import com.networkproject.queries.UnitQueries;
import com.networkproject.repository.UnitRepository;

public class UnitRepositoryImpl implements UnitRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	@Override
	public Unit saveUnit(final Unit unit) {

		try {

			this.transaction.begin();

			this.entityManager.persist(unit);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return unit;
	}

	@Override
	public Unit updateUnit(final Unit unit) {

		try {

			this.transaction.begin();

			this.entityManager.merge(unit);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return unit;
	}

	@Override
	public Unit deleteUnit(Unit unit) {

		try {

			if (this.entityManager.contains(unit)) {
				this.entityManager.remove(unit);
			} else {
				Unit tempUnit = this.findUnitById(unit.getUnitId());
				this.entityManager.remove(tempUnit);
			}

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}

		return unit;
	}

	@Override
	public List<Unit> findAllUnits() {

		List<Unit> units = null;

		try {

			TypedQuery<Unit> typedQuery = this.entityManager.createQuery(UnitQueries.findAllUnits, Unit.class);

			units = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return units;
	}

	@Override
	public List<String> findAllUnitNames() {

		List<String> unitNames = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(UnitQueries.findAllUnitNames, String.class);

			unitNames = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return unitNames;
	}

	@Override
	public Unit findUnitById(final int unitId) {

		Unit unit = null;

		try {

			TypedQuery<Unit> typedQuery = this.entityManager.createQuery(UnitQueries.findUnitById, Unit.class);
			typedQuery.setParameter("unitId", unitId);

			unit = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return unit;
	}

	@Override
	public ArrayList<String> findUnitNamesByProvinceId(final int provinceId) {

		ArrayList<String> unitNames = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(UnitQueries.findUnitNamesByProvinceId, String.class);
			typedQuery.setParameter("provinceId", provinceId);
			
			unitNames = (ArrayList<String>) typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return unitNames;
	}

	@Override
	public List<Unit> findUnitsByProvinceId(final int provinceId) {

		List<Unit> units = null;

		try {

			TypedQuery<Unit> typedQuery = this.entityManager.createQuery(UnitQueries.findUnitsByProvinceId, Unit.class);
			typedQuery.setParameter("provinceId", provinceId);
			
			units = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return units;
	}

	@Override
	public Unit findUnitByUnitName(String unitName) {

		Unit unit = null;

		try {

			TypedQuery<Unit> typedQuery = this.entityManager.createQuery(UnitQueries.findUnitByUnitName, Unit.class);
			typedQuery.setParameter("unitName", unitName);
			
			unit = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return unit;
	}
	
}
