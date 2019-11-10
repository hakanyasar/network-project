package com.networkproject.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.user.Role;
import com.networkproject.model.user.User;
import com.networkproject.queries.RoleQueries;
import com.networkproject.queries.UserQueries;
import com.networkproject.repository.RoleRepository;

public class RoleRepositoryImpl implements RoleRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	@Override
	public Role saveRole(final Role role) {

		try {

			this.transaction.begin();

			this.entityManager.persist(role);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return role;
	}

	@Override
	public Role updateRole(final Role role) {

		try {

			this.transaction.begin();

			this.entityManager.merge(role);

			this.transaction.commit();

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}

		}

		return role;
	}

	@Override
	public Role deleteRole(Role role) {

		try {

			if (this.entityManager.contains(role)) {
				this.entityManager.remove(role);
			} else {
				Role tempRole = this.findRoleById(role.getRoleId());
				this.entityManager.remove(tempRole);
			}

		} catch (RuntimeException e) {

			System.out.println("error: " + e);

			try {
				this.transaction.rollback();

			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}

		return role;
	}

	@Override
	public Role findRoleById(final int roleId) {

		Role role = null;

		try {

			TypedQuery<Role> typedQuery = this.entityManager.createQuery(RoleQueries.findRoleById, Role.class);
			typedQuery.setParameter("roleId", roleId);
			
			role = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return role;
	}

	@Override
	public Role findRoleByUserId(int userId) {

		Role role = null;

		try {

			TypedQuery<Role> typedQuery = this.entityManager.createQuery(RoleQueries.findRoleByUserId, Role.class);
			typedQuery.setParameter("userId", userId);
			
			role = typedQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}

		return role;
	}

}
