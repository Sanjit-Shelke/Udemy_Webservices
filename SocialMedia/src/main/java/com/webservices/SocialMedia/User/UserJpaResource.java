package com.webservices.SocialMedia.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservices.SocialMedia.jpa.UserRepository;

@RestController
public class UserJpaResource {

	private UserDaoService service;
	private UserRepository repository;
	
	public UserJpaResource(UserDaoService service, UserRepository repository)
	{
		this.service=service;
		this.repository=repository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	/**
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user= service.findOne(id);
		
		if (user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		
		return user;
	}
	**/
	
	//EntityModel
	//WebMvcLinkBuilder
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user= repository.findById(id);
		
		if (user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void DeleteUser(@PathVariable int id){
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User savedUser= repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() //1.from current URI i.e. /users
						.path("/{id}")									//2.add a path i.e. /id   [/users/{id}]
						.buildAndExpand(savedUser.getId())				//3.replace id with the created user id [/users/2]
						.toUri();										//4.Convert it to URI 
		return ResponseEntity.created(location).build();				//5.return URI [/users/2] 
	}
}
