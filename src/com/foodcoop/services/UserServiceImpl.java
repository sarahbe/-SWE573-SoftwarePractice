package com.foodcoop.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.DataAccessException;

import com.foodcoop.dao.UserDao;
import com.foodcoop.dao.UserRoleDao;
import com.foodcoop.domain.Product;
import com.foodcoop.domain.User;
import com.foodcoop.domain.UserRole;

@Configurable
public class UserServiceImpl implements UserService  {

	@Autowired
	UserDao userdao;
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	public void insertData(User user) {

			userdao.insertData(user);
		
	}

	@Override
	public List<User> getUserList() {
		List<User> userList = userdao.getUserList();

		for (User item : userList) {
			List<UserRole> userroleList = userRoleDao
					.getUserRoleListByUser(item.getUserId());
			for (UserRole roleItem : userroleList) {
				switch (roleItem.getRoleId()) {
				case 1:
					item.setMemberActive(roleItem.getValid());
					break;
				case 2:
					item.setAdminActive(roleItem.getValid());
					;
					break;
				case 3:
					item.setSalerActive(roleItem.getValid());
					;
					break;
				case 4:
					item.setStockerActive(roleItem.getValid());
					;
					break;
				}
			}
		}

		return userList;
	}

	@Override
	public void deleteData(String id) {
		userdao.deleteData(id);

	}
	
	@Override
	public User getUser(String id) {
		User user = userdao.getUser(id);
		UserRole userRole = userRoleDao
				.getUserRoleListByUser(Integer.parseInt(id)).get(0);
		user.setIdRole(userRole.getRoleId());
		return user;
	}

	@Override
	public void updateData(User user) {
		userdao.updateData(user);
	}

	@Override
	public void grantUserRole(String userId, int idRole, boolean active) {
		UserRole userrole = userRoleDao.getUserRole(userId, idRole);

		userrole.setUserId(Integer.parseInt(userId));
		userrole.setRoleId(idRole);
		userrole.setValid(active);
		if (userrole.getId() > 0) {
			userRoleDao.updateData(userrole);
		} else {
			userRoleDao.insertData(userrole);
		}
	}

	@Override
	public User getUserByEmail(String email, String password) {
		return userdao.getUserByEmail(email, password);
	}
	@Override
	public User getUserByEmail(String email) {
		
		User user = userdao.getUserByEmail(email);
		List<UserRole> userroleList = userRoleDao
				.getUserRoleListByUser(user.getUserId());
		for (UserRole roleItem : userroleList) {
			switch (roleItem.getRoleId()) {
			case 1:
				user.setMemberActive(roleItem.getValid());
				break;
			case 2:
				user.setAdminActive(roleItem.getValid());
				;
				break;
			case 3:
				user.setSalerActive(roleItem.getValid());
				;
				break;
			case 4:
				user.setStockerActive(roleItem.getValid());
				;
				break;
			}
		}
		return user;
	}
	
	
}
