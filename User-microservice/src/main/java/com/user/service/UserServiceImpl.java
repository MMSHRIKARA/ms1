package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.DTO.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repo.UserrRepoistory;
import com.user.security.UserInfoUserDetails;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserrRepoistory userrRepoistory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u=userrRepoistory.findByUsername(username);
		  
		  return u.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(username));
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.userrRepoistory.save(user) ;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return this.userrRepoistory.findAll();
	}

	@Override
	public Optional<User> getUserById(long userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> u=this.userrRepoistory.findById(userId);
		if(u.isEmpty())
			throw new UserNotFoundException("id does not exist");
		return this.userrRepoistory.findById(userId);
	}

	@Override
	public User editUser(UserDTO userDao) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=userrRepoistory.findById(userDao.getId());
		if(user.isEmpty())
			throw new UserNotFoundException("id does not exist to delete");
		User updateUser=user.get();
		updateUser.setUsername(userDao.getUsername());
		updateUser.setEmail(userDao.getEmail());
		updateUser.setContact(userDao.getContact());
		updateUser.setPassword(userDao.getPassword());
		return updateUser;
	}

	@Override
	public User deleteUserById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=this.userrRepoistory.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id does not exist to delete");
		 this.userrRepoistory.deleteById(id);
		 
		 return user.get();
	}
	
	public User logIn(String username, String password) {
		 
		User user = userrRepoistory.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("Invalid password or username"));
 
		if (!user.getPassword().equals(password)) {
			throw new UserNotFoundException("Invalid password or username");
		}
 
		return user;
 
	}

}
