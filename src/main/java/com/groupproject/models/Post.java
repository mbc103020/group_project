package com.groupproject.models;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Length(min = 2, message="title must have at least 2 characters")
	@NotEmpty(message="title missing")
	private String title;
	
	private int likes;
	
	private String body;  //content area 
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
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
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "user_id", nullable=false)
	@NotNull
	private User user;
	
	//comments 
	@OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
	private Collection<Comment> comments;
	
	public Post() {
		
	}
	
	
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
    public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
    
}
