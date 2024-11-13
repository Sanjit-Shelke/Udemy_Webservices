package com.webservices.SocialMedia.User;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user_details")
public class User {
	
	protected User() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message = "Name should have atleast 2 character")
	//@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birthdate should be in past")
	//@JsonProperty("birth_date")
	private LocalDate birthdate;
	
	
	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	

}
