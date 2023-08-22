package com.mtco.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {
	
	// controller katmanından anlık olarak login olan kullanıcıya ihtiyacımız olunca
	
	public static Optional<String> getCurrentUserLogin(){
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		Authentication authentication = securityContext.getAuthentication();
		
		return Optional.ofNullable(extractPrinciple(authentication)); 
		//null pointer exceptiondan kacinmak amaciyla donen deger nullsa onu optional icinde dondurmus oluyoruz
	}
	
	private static String extractPrinciple(Authentication authentication) {
		if(authentication == null) {
			return null;
			
		// AuthTokenFilterda security contexte gonderirken user details gondermistik
		// yapıyı o sekilde kurmak zorunda degiliz sadece email gonderedebilirdik:
		}else if(authentication.getPrincipal() instanceof UserDetails) { 
			UserDetails secureUser = (UserDetails) authentication.getPrincipal();
			return secureUser.getUsername();
			
		}else if(authentication.getPrincipal() instanceof String) {
			return (String)authentication.getPrincipal();
		}
		
		return null;
		
	}
	
	
}
