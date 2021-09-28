package com.groupproject.models;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lookbookposts")
public class LookBookPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String title; 
	
	@Column
	private String imageName; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss") 
    private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}
	//for one to many, user can have many lookbook posts
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User lookBookPostAuthor;
	 
	//for many to many, many lookbookposts can have many comments from many users
	@OneToMany(mappedBy="userWhoCommented")
    private List<LookBookPostComment> lookBookPostComments;
	
	//for many to many, lookbook post can be liked by many users
	@OneToMany(mappedBy="userWhoLiked", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private List <UserLookBookPostLike> usersWhoLikedLookBookPost; 
	
	public LookBookPost() {
		
	}
	
	public LookBookPost(String title, String imageName) {
		this.title = title; 
		this.imageName = imageName; 
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
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

	public User getLookBookPostAuthor() {
		return lookBookPostAuthor;
	}

	public void setLookBookPostAuthor(User lookBookPostAuthor) {
		this.lookBookPostAuthor = lookBookPostAuthor;
	}

	public List<LookBookPostComment> getLookBookPostComments() {
		return lookBookPostComments;
	}

	public void setLookBookPostComments(List<LookBookPostComment> lookBookPostComments) {
		this.lookBookPostComments = lookBookPostComments;
	}

	public List<UserLookBookPostLike> getUsersWhoLikedLookBookPost() {
		return usersWhoLikedLookBookPost;
	}

	public void setUsersWhoLikedLookBookPost(List<UserLookBookPostLike> usersWhoLikedLookBookPost) {
		this.usersWhoLikedLookBookPost = usersWhoLikedLookBookPost;
	}

	
	

}
