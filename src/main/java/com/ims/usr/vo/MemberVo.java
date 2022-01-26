package com.ims.usr.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberVo implements UserDetails {
	private String email;
	private String password;
	private List<String> roles = new ArrayList<>();
	private String role;
	private String username;
	private Date frstdt;
	private Date frstid;
	private Date upstdt;
	private Date upstid;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		// TODO Auto-generated method stub
		return this.roles.stream().map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
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
	
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getFrstdt() {
		return frstdt;
	}
	public void setFrstdt(Date frstdt) {
		this.frstdt = frstdt;
	}
	public Date getFrstid() {
		return frstid;
	}
	public void setFrstid(Date frstid) {
		this.frstid = frstid;
	}
	public Date getUpstdt() {
		return upstdt;
	}
	public void setUpstdt(Date upstdt) {
		this.upstdt = upstdt;
	}
	public Date getUpstid() {
		return upstid;
	}
	public void setUpstid(Date upstid) {
		this.upstid = upstid;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
}


