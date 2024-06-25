package com.user.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repo.UserrRepoistory;


@Service
public class UserInfoService implements UserDetailsService  {
	
	@Autowired
	private UserrRepoistory userrRepoistory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> u=userrRepoistory.findByUsername(username);
		  
		  return u.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(username));
	}

}
