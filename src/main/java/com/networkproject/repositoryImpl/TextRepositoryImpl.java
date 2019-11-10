package com.networkproject.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.Text;
import com.networkproject.model.TextDetails;
import com.networkproject.queries.TextQueries;
import com.networkproject.repository.TextRepository;

public class TextRepositoryImpl implements TextRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	
	@Override
	public Text saveText(final Text text) {

		try {

			this.transaction.begin();

			this.entityManager.persist(text);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return text;
	}

	@Override
	public Text updateText(final Text text) {

		try {

			this.transaction.begin();

			this.entityManager.merge(text);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return text;
	}

	@Override
	public Text deleteText(final Text text) {

		try {
			this.transaction.begin();

			this.entityManager.remove(text);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}

		System.out.println("silme islemi gerceklestirildi..**************************");
		return text;
	}

	
	@Override
	public List<Text> findAllText() {

		List<Text> texts = null;

		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findAllTexts, Text.class);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}
	

	@Override
	public Text findTextById(final int textId) {

		Text text = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextById, Text.class);
			typedQuery.setParameter("textId", textId);

			text = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return text;
	}
	

	@Override
	public List<Text> findTextsByUnitId(final int unitId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUnitId, Text.class);
			typedQuery.setParameter("unitId", unitId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	
	public List<TextDetails> findTextDetails() {

		List<TextDetails> textDetails = null;

		try {

			TypedQuery<TextDetails> typedQuery = this.entityManager.createQuery(TextQueries.findTextDetails, TextDetails.class);

			textDetails = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return textDetails;
	}

	@Override
	
	public TextDetails findTextDetailsByTextId(final int textId) {

		TextDetails textDetails = null;

		try {

			TypedQuery<TextDetails> typedQuery = this.entityManager.createQuery(TextQueries.findTextDetailsByTextId, TextDetails.class);
			typedQuery.setParameter("textId", textId);
			
			textDetails = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return textDetails;
	}

	@Override
	
	public List<String> findTextSubjects() {

		List<String> textSubjects = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(TextQueries.findTextSubjects, String.class);

			textSubjects = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return textSubjects;
	}

	@Override
	public List<Text> findTextsByRouterId(final int routerId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByRouterId, Text.class);
			typedQuery.setParameter("routerId", routerId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	
	@Override
	public List<Text> findTextsByRouterId_UnitId_ProvinceId(final int routerId, final int unitId, final int provinceId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByRouterId_UnitId_ProvinceId, Text.class);
			typedQuery.setParameter("routerId", routerId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("provinceId", provinceId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	
	@Override
	public List<Text> findTextsByUserName(String userName) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserName, Text.class);
			typedQuery.setParameter("userName", userName);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByRouterBrand(String routerBrand) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByRouterBrand, Text.class);
			typedQuery.setParameter("routerBrand", routerBrand);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByRouterModel(String routerModel) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByRouterModel, Text.class);
			typedQuery.setParameter("routerModel", routerModel);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByProvinceName(String provinceName) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByProvinceName, Text.class);
			typedQuery.setParameter("provinceName", provinceName);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByUnitName(String unitName) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUnitName, Text.class);
			typedQuery.setParameter("unitName", unitName);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	
	//////////////////////////////////////////////////////////////////////////
	//asagýdaki kýsým, aciklamalari gör panelindeki comboBox lar için olan sorgular
	/////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Text> findTextsByUserId(int userId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserId, Text.class);
			typedQuery.setParameter("userId", userId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	
	@Override
	public List<Text> findTextsByProvinceId(final int provinceId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByProvinceId, Text.class);
			typedQuery.setParameter("provinceId", provinceId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByUserIdAndProvinceId(int userId, int provinceId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserIdAndProvinceId, Text.class);
			typedQuery.setParameter("userId", userId);
			typedQuery.setParameter("provinceId", provinceId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByUserIdAndProvinceIdAndUnitId(int userId, int provinceId, int unitId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserIdAndProvinceIdAndUnitId, Text.class);
			typedQuery.setParameter("userId", userId);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandName(int userId, int provinceId, int unitId, String routerBrand) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandName, Text.class);
			typedQuery.setParameter("userId", userId);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("routerBrand", routerBrand);
			
			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;

	}

	@Override
	public List<Text> findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(int userId, int provinceId, int unitId, String routerBrand, String routerModel) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName, Text.class);
			typedQuery.setParameter("userId", userId);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("routerBrand", routerBrand);
			typedQuery.setParameter("routerModel", routerModel);
			
			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public List<Text> findTextsByProvinceIdAndUnitId(int provinceId, int unitId) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByProvinceIdAndUnitId, Text.class);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;

	}

	@Override
	public List<Text> findTextsByProvinceIdAndUnitIdAndRouterBrandName(int provinceId, int unitId, String routerBrand) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByProvinceIdAndUnitIdAndRouterBrandName, Text.class);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("routerBrand", routerBrand);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;

	}

	@Override
	public List<Text> findTextsByProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(int provinceId, int unitId, String routerBrand, String routerModel) {

		List<Text> texts = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextsByProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName, Text.class);
			typedQuery.setParameter("provinceId", provinceId);
			typedQuery.setParameter("unitId", unitId);
			typedQuery.setParameter("routerBrand", routerBrand);
			typedQuery.setParameter("routerModel", routerModel);

			texts = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return texts;
	}

	@Override
	public Text findTextByText(String theText) {

		Text text = null;
		
		try {

			TypedQuery<Text> typedQuery = this.entityManager.createQuery(TextQueries.findTextByText, Text.class);
			typedQuery.setParameter("text", theText);
			
			text = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return text;
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	//aciklamalari gör panelindeki comboBox lar için olan sorgular burada bitiyor
	/////////////////////////////////////////////////////////////////////////
	
}
