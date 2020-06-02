package com.guardon.springbootswagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guardon.springbootswagger2.model.User;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id){
		return users.get(id);
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return new ArrayList<User>(users.values());
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user){
		users.put(user.getId(), user);
		return user;
	}
}
