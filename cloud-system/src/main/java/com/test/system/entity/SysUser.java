//package com.test.system.entity;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class SysUser implements UserDetails {
//	
//	/*user id*/
//    private String id;
// 
//    private String userName;
// 
//    private String password;
//    
//    private Date lastPasswordResetDate;
//    
//    private List<SysRole> roles;
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<SysRole> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<SysRole> roles) {
//		this.roles = roles;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> auths = new ArrayList<>();
//        List<SysRole> roles = this.getRoles();
//        for (SysRole role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return auths;
//	}
//
//	public Date getLastPasswordResetDate() {
//		return lastPasswordResetDate;
//	}
//
//	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
//		this.lastPasswordResetDate = lastPasswordResetDate;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//    
//
//}
