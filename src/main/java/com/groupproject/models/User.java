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
	private String firstName;
	
	@NotEmpty(message="Name missing")
	@Size(min=2, max=60, message="Name must be more than 2 characters!")
	private String lastName;
	
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
    
    //relationships - posts
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Post> post;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts;

    //relationships - offers
    @OneToMany(fetch=FetchType.LAZY, mappedBy="planner")
    private List<Offer> offerPosted;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="users_offers",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="offer_id")
	)
    private List<Offer> offersAppliedTo;
    
    public User() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	

//	public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
