package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.User;

public interface UserService {
	User saveUser(User employee);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
}