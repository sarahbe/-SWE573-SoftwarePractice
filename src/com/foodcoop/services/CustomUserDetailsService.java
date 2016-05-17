package com.foodcoop.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(
		readOnly = true)
@Configurable
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Autowired
	UserRoleService userRoleService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserDetails user = null;

		try {
			com.foodcoop.domain.User dbUser = userService
					.getUserByEmail(username);
			user = new User(dbUser.getEmail(),
					dbUser.getPassword().toLowerCase(), true, true, true, true,
					getAuthorities(dbUser));

		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(
			com.foodcoop.domain.User user) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		if (user.getMemberActive()) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		if (user.getAdminActive()) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		if (user.getSalerActive()) {
			authList.add(new SimpleGrantedAuthority("ROLE_SALER"));
		}
		if (user.getStockerActive()) {
			authList.add(new SimpleGrantedAuthority("ROLE_STOCKER"));
		}

		// Return list of granted authorities
		return authList;
	}
}