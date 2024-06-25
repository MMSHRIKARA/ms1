package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.user.DTO.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

public interface UserService {
	
public User addUser(User user);
	
	public List<User> getUser(); 
	
	public Optional<User> getUserById(long userId) throws UserNotFoundException;
	
	public User deleteUserById(Long id) throws UserNotFoundException;
	
	public User editUser(UserDTO userDao) throws UserNotFoundException;

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
