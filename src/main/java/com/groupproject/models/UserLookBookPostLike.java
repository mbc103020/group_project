package com.groupproject.models;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="userlookbookpostlikes")
public class UserLookBookPostLike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userWhoLiked; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lookbookpostlike_id")
	LookBookPost lookBookPost; 
	
	public UserLookBookPostLike() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public User getUserWhoLiked() {
		return userWhoLiked;
	}

	public void setUserWhoLiked(User userWhoLiked) {
		this.userWhoLiked = userWhoLiked;
	}

	public LookBookPost getLookBookPost() {
		return lookBookPost;
	}

	public void setLookBookPost(LookBookPost lookBookPost) {
		this.lookBookPost = lookBookPost;
	}

}
