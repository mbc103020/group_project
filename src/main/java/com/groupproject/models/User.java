package com.groupproject.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import java.util.*;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name missing")
	@Size(min=2, max=60, message="Name must be more than 2 characters!")
	private String firstname;
	
	@NotEmpty(message="Name missing")
	@Size(min=2, max=60, message="Name must be more than 2 characters!")
	private String lastname;
	
	@NotEmpty(message="email missing")
	@Email(message="Email must be valid")
    private String email;
	
	private String gender;
	private Date birthdate;
	private String city; 
	private String state;
	private String photo;
	
	@NotEmpty(message="Password missing")
	@Size(min=8, message="Password must be greater than 8 characters")
    private String password;
	
	
    @Transient
    @NotEmpty(message="Confirm Password missing")
    private String confirmPassword;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "blog_id")
    )
    private List<Blog> blogs;

    
    public User() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDOB() { 
		return birthdate;
	}
	
	public void setDOB(Date birthdate) { 
		this.birthdate = birthdate;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) { 
		this.city = city; 
	}
	
	public String getState() { 
		return state;
	}
	
	public void setState(String state) { 
		this.state= state;
	}
	
	public String getPhotos() { 
		return photo;
	}
	
	public void setPhotos(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
