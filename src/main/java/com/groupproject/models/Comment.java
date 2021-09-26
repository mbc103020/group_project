package com.groupproject.models;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String body;

   
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;


//relationships
    //post can have many comments but a single comment cannot have many post( one comment cannot be found under multiple posts)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //users can have many comments but a single comment cannot have many users 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    public Comment() { 
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
	
    //posts
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    
    //users
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
