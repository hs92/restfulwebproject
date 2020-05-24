package com.spring.restful.restfulwebproject.controller;

import java.util.List;
import javax.annotation.Resource;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.restful.restfulwebproject.domain.User;
import com.spring.restful.restfulwebproject.exception.UserNotFoundException;
import com.spring.restful.restfulwebproject.service.UserService;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> retreiveAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/getUsers/{id}")
	public EntityModel<User> getUser(@PathVariable int id) throws UserNotFoundException {
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		EntityModel<User> resouce = new EntityModel<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retreiveAllUsers());
		
		resouce.add(linkTo.withRel("all-users"));
		return resouce;
	}
	
	@PostMapping("/addUser")
	public List<User> createUser(@RequestBody User user) {
		return userService.save(user);
	}
}
