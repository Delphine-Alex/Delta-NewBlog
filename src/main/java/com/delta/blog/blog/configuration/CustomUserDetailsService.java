package com.delta.blog.blog.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.delta.blog.blog.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		com.delta.blog.blog.model.User user= userRepository.findByName(name);
		if(user==null) {
			throw new UsernameNotFoundException(name+" not found");
		}
		
		User user1 = new User(
				user.getName(),
				user.getPassword(),
				getGrantedAuthorities());
		return user1;
	}
	private List<GrantedAuthority> getGrantedAuthorities() {
		List<GrantedAuthority> autorities= new ArrayList<GrantedAuthority>();
		autorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return autorities;
	}
	
}