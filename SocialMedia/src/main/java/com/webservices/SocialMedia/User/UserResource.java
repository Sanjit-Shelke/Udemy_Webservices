package com.webservices.SocialMedia.User;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service)
	{
		this.service=service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user= service.findOne(id);
		
		if (user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void DeleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User savedUser= service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() //1.from current URI i.e. /users
						.path("/{id}")									//2.add a path i.e. /id   [/users/{id}]
						.buildAndExpand(savedUser.getId())				//3.replace id with the created user id [/users/2]
						.toUri();										//4.Convert it to URI 
		return ResponseEntity.created(location ).build();				//5.return URI [/users/2] 
	}
}
