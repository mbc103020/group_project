package com.groupproject.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="offers")
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotNull
	private Long rate; //$$
	@NotEmpty
	private String company;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //many offers can be made by one user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User employer;
    
    //many users can apply to many offers
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="users_offers",
		joinColumns = @JoinColumn(name="offer_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
	)
    
    //all the users who applied for this offer
    private List<User> applicants;
    
    // how many ppl have applied
    private int applicantCount = 0;
    
    //CONSTRUCTOR
    public Offer() {}
	public Offer(Long id, String title,  String city,  String state,  Long rate, String company) {
		this.id = id;
		this.title = title;
		this.city = city;
		this.state = state;
		this.rate = rate;
		this.company = company;
	}
    
	//GETTERS AND SETTERS
	
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
		this.state = state;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public User getEmployer() {
		return employer;
	}

	public void setEmployer(User employer) {
		this.employer = employer;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}
	
	 public int getApplicantCount() {
			return applicantCount;
		}
		public void setApplicantCount(int applicantCount) {
			this.applicantCount = applicantCount;
		}
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
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

	
}
