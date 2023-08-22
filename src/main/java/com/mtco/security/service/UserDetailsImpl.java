package com.mtco.security.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mtco.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L; //TODO bu olmayınca uyarı veriyo, ne olduğunu araştır

	private String email; // User email ile log in olacağı için (normalde id ile çalışıyor)
	
	private String password;
	
	// roller GrantedAuthority turunden olmali
	private Collection<? extends GrantedAuthority> authorities;
	
	//User -> UserDetail donusumu
	public static UserDetailsImpl build(User user) {
		List<SimpleGrantedAuthority> authorities =  user.getRoles().
				stream().
				map(role->new SimpleGrantedAuthority(role.getRoleType().
				name())).
				collect(Collectors.toList());
		return new UserDetailsImpl(user.getEmail(),user.getPassword(),authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
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
