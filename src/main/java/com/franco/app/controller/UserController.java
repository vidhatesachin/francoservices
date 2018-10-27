package com.franco.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.franco.app.dataobjects.User;
import com.franco.app.exception.AuthenticationFailureException;
import com.franco.app.exception.ResourceConflictException;
import com.franco.app.repository.UserRepository;
import com.franco.app.vo.LoginVO;


@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginVO loginVO) throws IOException {
		logger.info("login() ..... Start");
		User user = this.userRepository.findByEmailAndPassword(loginVO.getUsername(),loginVO.getPassword());
		if(user==null) {
			throw new AuthenticationFailureException("Invalid login credentials");
		}
		user.setPassword(null);
		logger.info("login() ..... End");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(path = "user/list/{roleId}")
	public ResponseEntity<List<User>> usersListByRole(@PathVariable("roleId") String roleId) {
		List<User> users = this.userRepository.getUserByRole(Long.parseLong(roleId));
		users.forEach(user -> user.setPassword(null));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping(path = "/allusers")
	public ResponseEntity<List<User>> usersList() {
		List<User> users = this.userRepository.getAllUsers();
		users.forEach(user -> user.setPassword(null));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping(path = "user/{userId}")
	public ResponseEntity<User> user(@PathVariable("userId") String userId) {
		User user = this.userRepository.findOne(Long.parseLong(userId));
		user.setPassword(null);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws IOException {
		logger.info("saveuser() ..... Start");
		User existinguser = this.userRepository.findByEmail(user.getEmail());
		if(existinguser!=null) {
			throw new ResourceConflictException("User with same email already exist");
		}
		user.setStatus('A');
		User savedUser = this.userRepository.save(user);
		logger.info("saveUser() ..... End");
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws IOException {
		logger.info("updateuser() ..... Start");
		User existinguser = this.userRepository.findByEmail(user.getEmail());
		if(existinguser!=null && existinguser.getId()!=user.getId()) {
			throw new ResourceConflictException("User with same email already exist");
		}
		User savedUser = this.userRepository.save(user);
		logger.info("updateUser() ..... End");
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}

}
