package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

	@GetMapping({ "/users" })
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> user = userService.getAllUsers();
		return ResponseEntity.ok(user);
	}

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@GetMapping({ "/forInstructor" })
	@PreAuthorize("hasRole('Instructor')")
	public String forInstructor() {
		return "This URL is only accessible to the instructor";
	}

	@GetMapping({ "/forUser" })
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accessible to the user";
	}

	@GetMapping("/api/user/{userName}")
	public ResponseEntity<?> getUsersById(@PathVariable("userName") String userName) {
		Optional<User> user = userService.getUserByUserName(userName);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
