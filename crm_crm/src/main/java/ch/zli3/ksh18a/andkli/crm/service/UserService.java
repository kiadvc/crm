package ch.zli3.ksh18a.andkli.crm.service;

import java.util.List;

import ch.zli3.ksh18a.andkli.crm.model.AppUser;

public interface UserService {
	
	List<AppUser> getAllUsers();
	
	AppUser addUser(String userName, String password, List<String> roles);
	
	AppUser findByUserName(String userName);

	AppUser getUserById(long userId);

	void deleteUserById(Long userId);
	
	AppUser setRolesForUser(long id, List<String> roles);

}
