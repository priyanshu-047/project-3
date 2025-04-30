package com.techcom.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String title;
    
    @Column(nullable = false)
    private String description;
    
    //=============================================
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<user> users;
    
    private int price;
    
    @OneToMany(mappedBy = "course")
    @JsonBackReference
    private List<lessons>  lessons;
    
    public List<user> getUsers() {
		return users;
	}



	public void setUsers(List<user> users) {
		this.users = users;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Course() {}
    
    public Course(String title, String description, user instructor) {
        this.title = title;
        this.description = description;
       
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
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

	public List<lessons> getLessons() {
		return lessons;
	}

	public void setLessons(List<lessons> lessons) {
		this.lessons = lessons;
	}

}
