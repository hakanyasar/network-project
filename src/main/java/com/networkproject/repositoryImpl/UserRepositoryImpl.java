package com.networkproject.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.user.User;
import com.networkproject.queries.UserQueries;
import com.networkproject.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	
	@Override
	public User saveUser(final User user) {

		try {

			this.transaction.begin();

			this.entityManager.persist(user);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return user;
	}

	@Override
	public User updateUser(final User user) {

		try {

			this.transaction.begin();

			this.entityManager.merge(user);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return user;
	}

	@Override
	public User deleteUser(User user) {

		try {

			if (this.entityManager.contains(user)) {
				this.entityManager.remove(user);
			} else {
				User tempUser = this.findUserById(user.getUserId());
				this.entityManager.remove(tempUser);
			}

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}

		return user;
	}

	@Override
	public User findUserById(final int userId) {

		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findUserById, User.class);
			typedQuery.setParameter("userId", userId);
			
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return user;
	}

	@Override
	public User findUserByTextId(final int textId) {

		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findUserByTextId, User.class);
			typedQuery.setParameter("textId", textId);
			
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return user;
	}

	
	@Override
	public Boolean findUserByUsernameAndPassword(String userName, String password) {
		
		Boolean temp = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findUserByUsernameAndPassword, User.class);
			typedQuery.setParameter("userName", userName);
			typedQuery.setParameter("password", password);
			
		    temp = typedQuery.getResultList().isEmpty();
		    
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return !temp;
		
	}

	@Override
	public User findUserByUserName(String userName) {

		User user = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findUserByUserName, User.class);
			typedQuery.setParameter("userName", userName);
			
			user = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return user;
	}

	@Override
	public List<User> findAllUsers() {

		List<User> users = null;

		try {

			TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQueries.findAllUsers, User.class);
			
			users = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return users;
	}

	@Override
	public List<String> findAllUserNames() {

		List<String> userNames = null;

		try {

			TypedQuery<String> typedQuery = this.entityManager.createQuery(UserQueries.findAllUserNames, String.class);

			userNames = typedQuery.getResultList();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return userNames;
		
	}

	@Override
	public Integer findUserIdByUserName(String userName) {
		int userId = 0;

		try {

			TypedQuery<Integer> typedQuery = this.entityManager.createQuery(UserQueries.findUserIdByUserName, Integer.class);
			typedQuery.setParameter("userName", userName);
			
			userId = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return userId;
	}

	
}
