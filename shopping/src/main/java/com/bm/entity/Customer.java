package com.bm.entity;

import javax.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Long cid;
	
	@Column(name = "username", length = 255, nullable = false)
	private String username;
	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	@Column(name = "phoneNumber", length = 255, nullable = false)
	private String phoneNumber;
	
//	@ManyToMany
//	@JoinTable(
//			name = "user_product",
//			joinColumns = @JoinColumn(name = "cid"),
//			inverseJoinColumns = @JoinColumn(name = "pid"))
//	private List<Product> Products;
	
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
