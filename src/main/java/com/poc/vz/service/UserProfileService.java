/**
 * 
 */
package com.poc.vz.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.poc.vz.model.Order;
import com.poc.vz.model.Product;
import com.poc.vz.model.Repair;
import com.poc.vz.model.User;
import com.poc.vz.model.UserProfile;
import com.poc.vz.request.UserRequest;

/**
 * @author ranjit.soni
 *
 */

@RequestScoped
public class UserProfileService {

	@Inject
	private EntityManager entityManager;
	
	@Transactional
	public User save(UserRequest profileRequest)
	{
		User user = new User();
		user.setName(profileRequest.getName());
		user.setMobileNumber(profileRequest.getMobileNumber());
		user.setEmailId(profileRequest.getEmailId());
		user = save(user);
		
		return user;
		
	}
	
	@Transactional
	public User save(User user)
	{
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}
	
	@Transactional
	public UserProfile checkUserProfile(String mobileNumber)
	{
		try
		{
			Query query = entityManager.createQuery("Select up from UserProfile up where mobileNumber = :mobileNumber");
			query.setParameter("mobileNumber", mobileNumber);
			UserProfile userProfile = (UserProfile) query.getSingleResult();
			return userProfile;
		}
		catch(NoResultException exception)
		{
			return null;
		}
		catch(NonUniqueResultException exception)
		{
			return null;
		}
	}
	
	@Transactional
	public UserProfile createUserprofile(UserProfile userProfile)
	{
		try
		{
			UserProfile userProfile2 = entityManager.find(UserProfile.class, userProfile.getUserProfileId());
			if(userProfile2 == null)
			{
				entityManager.persist(userProfile);
				entityManager.flush();	
			}
			
			return userProfile;
		}
		catch(Exception exception)
		{
			return null;
		}
	}
	
	@Transactional
	public Order createOrderJob(Order order)
	{
		try
		{
			entityManager.persist(order);
			entityManager.flush();
			return order;
		}
		catch(Exception exception)
		{
			return null;
		}
	}
	
	@Transactional
	public Product saveProduct(Product product)
	{
		try
		{
			if(entityManager.find(Product.class, product.getProductId()) != null)
			{
				return product;
			}
			
			entityManager.persist(product);
			entityManager.flush();
			return product;
		}
		catch(Exception exception)
		{
			return null;
		}
	}
	
	@Transactional
	public UserProfile getUserProfile(String userProfileId)
	{
		UserProfile userProfile = entityManager.find(UserProfile.class, userProfileId);
		return userProfile;
	}
	
	@Transactional
	public List<Order> getPurchasedOrder(String userProfileId)
	{
		Query query = entityManager.createQuery("Select jb from Order jb where userProfileId=:userProfileId");
		query.setParameter("userProfileId", userProfileId);
		@SuppressWarnings("unchecked")
		List<Order> orders = query.getResultList();
		return orders;
	}
	
	@Transactional
	public Product getOrderJob(String orderId)
	{
		Order order = entityManager.find(Order.class, orderId);
		if(order != null)
		{
			Product product = entityManager.find(Product.class, order.getProductId());
			return product;
		}
		
		return null;
	}
	
	@Transactional
	public Repair createRepairJob(Repair repair)
	{
		if(entityManager.find(Repair.class, repair.getRepairId()) != null)
		{
			return repair;
		}
		
		entityManager.persist(repair);
		entityManager.flush();
		return repair;
	}
	
	@Transactional
	public Order getOrder(String orderId)
	{
		Order order = entityManager.find(Order.class, orderId);
		return order;
	}

}
