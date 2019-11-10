package com.networkproject.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.Province;
import com.networkproject.queries.ProvinceQueries;
import com.networkproject.repository.ProvinceRepository;

public class ProvinceRepositoryImpl implements ProvinceRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	@Override
	public Province saveProvince(final Province province) {

		try {

			this.transaction.begin();

			this.entityManager.persist(province);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return province;
		
	}

	@Override
	public Province updateProvince(final Province province) {

		try {

			this.transaction.begin();

			this.entityManager.merge(province);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return province;
	}

	@Override
	public Province deleteProvince(Province province) {

		try {

			if (this.entityManager.contains(province)) {
				this.entityManager.remove(province);
			} else {
				Province tempProvince = this.findProvinceById(province.getProvinceId());
				this.entityManager.remove(tempProvince);
			}

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}

		return province;
	}

	@Override
	public List<Province> findAllProvinces() {

		List<Province> provinces = null;

		try {

			TypedQuery<Province> typedQuery = this.entityManager.createQuery(ProvinceQueries.findAllProvinces, Province.class);

			provinces = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return provinces;
	}

	@Override
	public List<String> findAllProvinceNames() {

		List<String> provinceNames = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(ProvinceQueries.findAllProvinceNames, String.class);

			provinceNames = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return provinceNames;
	}

	@Override
	public Province findProvinceById(final int provinceId) {

		Province province = null;

		try {

			TypedQuery<Province> typedQuery = this.entityManager.createQuery(ProvinceQueries.findProvinceById, Province.class);
			typedQuery.setParameter("provinceId", provinceId);
			
			province = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return province;
	}

	@Override
	public Province findProvinceByProvinceName(String provinceName) {
		
		Province province = null;

		try {

			TypedQuery<Province> typedQuery = this.entityManager.createQuery(ProvinceQueries.findProvinceByProvinceName, Province.class);
			typedQuery.setParameter("provinceName", provinceName);
			
			province = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return province;

	}

}
