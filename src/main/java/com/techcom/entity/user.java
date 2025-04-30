package com.techcom.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Component
@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, unique = true) 
    private String username;

    @Column(nullable = false) 
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;

    private String Name;
    

    private String profilePicture; 

    private String bio; 

    //=======================================================
    @ManyToMany(mappedBy = "users") 
    @JsonBackReference
    private List<Course> courses;

    
    public user() {}

    
    public user(String username, String email, String password, String role, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.Name = firstName;
        
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", Name=" + Name + ", profilePicture=" + profilePicture + ", bio=" + bio + ", courses="
				+ courses + "]";
	}
    
	

}
