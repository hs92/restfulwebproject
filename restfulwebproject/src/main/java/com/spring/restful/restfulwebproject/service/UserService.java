package com.spring.restful.restfulwebproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.spring.restful.restfulwebproject.domain.User;

@Component
public class UserService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Himanshu", new Date()));
		users.add(new User(2, "Ritu", new Date()));
		users.add(new User(3, "Keerti", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public List<User> save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return users;
	}
	
	public User findOne(int id) {
		List<User> findUser = users.stream().filter(user-> user.getId() == id).collect(Collectors.toList());
		if (findUser.size() > 0) {
			return findUser.get(0);
		}
		return null;
	}
}
