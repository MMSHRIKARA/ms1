package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.DTO.AuthRequest;
import com.user.DTO.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.jwt.JwtService;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to the page";
	}
	
	@GetMapping("/adminProfile")
	@PreAuthorize("hasAuthority('Admin')")
	public String AdminProfile() {
		return "Admin profile";
	}
	
	@GetMapping("/doctorProfile")
	@PreAuthorize("hasAuthority('Doctor')")
	public String DoctorProfile() {
		return "Doctor Profile";
	}
	
	@PostMapping("/addUser")
	public User addUser(@Valid@RequestBody UserDTO userDao) {
		User user=new User(userDao.getId(),userDao.getUsername(),userDao.getContact(),userDao.getEmail(),userDao.getPassword(),userDao.getRole());
		return this.userService.addUser(user);
	}
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> UserLogin(@PathVariable String username, @PathVariable String password) {
		User user = userService.logIn(username, password);
 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new  UsernameNotFoundException("invalid user");
		}
		
	}
	
	@GetMapping("/getUser")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> getUser() {
		return this.userService.getUser();
	}
	
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@Valid@PathVariable long id) throws UserNotFoundException {
		return this.userService.getUserById(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public User deleteUserById(@PathVariable Long id) throws UserNotFoundException {
		return this.userService.deleteUserById(id);
	}

}
