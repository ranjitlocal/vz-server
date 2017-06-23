/**
 * 
 */
package com.poc.vz.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.poc.vz.model.User;
import com.poc.vz.request.UserProfileRequest;

/**
 * @author ranjit.soni
 *
 */

@RequestScoped
public class UserProfileService {

	@Inject
	private EntityManager entityManager;
	
	@Transactional
	public User save(UserProfileRequest profileRequest)
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
}
