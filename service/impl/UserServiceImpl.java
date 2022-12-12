package net.javaguides.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("User", "Id", id));
		
	}

	@Override
	public User updateUser(User user, long id) {
		
		User existinguser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id)); 
		
		existinguser.setFirstName(user.getFirstName());
		existinguser.setLastName(user.getLastName());
		existinguser.setEmail(user.getEmail());
		userRepository.save(existinguser);
		return existinguser;
	}

	@Override
	public void deleteUser(long id) {
		
		userRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}
	
}