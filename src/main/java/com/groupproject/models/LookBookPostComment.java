package com.groupproject.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lookbookpostcomments")
public class LookBookPostComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String content; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")  //annotation from Spring
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
	//one to many, user can leave many lookbookpost comments
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userWhoCommented; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lookbookpost_id")
	private LookBookPost lookBookPost; 
	
	public LookBookPostComment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public User getUserWhoCommented() {
		return userWhoCommented;
	}

	public void setUserWhoCommented(User userWhoCommented) {
		this.userWhoCommented = userWhoCommented;
	}

	public LookBookPost getLookBookPost() {
		return lookBookPost;
	}

	public void setLookBookPost(LookBookPost lookBookPost) {
		this.lookBookPost = lookBookPost;
	}
	
	

}
