package com.groupproject.models;

//import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min = 2, message="title must have at least 2 characters")
	@NotEmpty(message="title missing")
	private String title;
	
	private int likes;
	//private String comments;
	
	private String content;  //content area 
	
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
	//Relationship
	
	//For likes 
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "post_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	 private List<User> users;  //do we need this??? 
	
//users who have  post
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//comments 
	@OneToMany(mappedBy="post", fetch = FetchType.LAZY)
	private List<Comment> comments;

	
	public Post() {	
	}
	
	//getters and setters 
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

      
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
	
	
	
	 //comments 
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    
    
    //likes
    public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
	//users
	public User getAUser() {
        return user;
    }

    public void setAUser(User user) {
        this.user = user;
    }
    
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
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
