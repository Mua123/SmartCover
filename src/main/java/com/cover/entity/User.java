package com.cover.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User {
    
    
    private String id;
    
    private String username;
    
    private String name;
    
	private String password;
    
    private String telephone;
    
    private String email;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override  
    public String toString() {  
        return "User [id=" + id + ",  username=" + username + ", name=" + name + ",  password="
          + password + ",telephone=" + telephone + ",email=" + email + "]"; 
    }
}

