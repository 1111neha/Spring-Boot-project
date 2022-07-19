package net.codejava.service;

import java.util.List;

import net.codejava.model.user;
public interface userService {
	List<user> getAlluser();
	void saveuser(user user);
	user getuserById(long id);
	 void deleteuserById(long id);
}
