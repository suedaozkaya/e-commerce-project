package com.mtco.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	// jwtExpirationMs ve jwtSecret degerleini application.yml dosyasindan aliyorum
	@Value("${ecommerce.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${ecommerce.app.jwtExpirationMs}") 
	private Long jwtExpirationMs;
	
	public String generateJwtToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername()).
										 setIssuedAt(new Date()).
										 setExpiration(new Date(new Date().getTime()+jwtExpirationMs)).
										 signWith(SignatureAlgorithm.HS512, jwtSecret).
										 compact();
	}
	
	 // jwt token icinden kullanicinin email bilgisi alinacak
	public String getEmailFromToken(String token) {
		return Jwts.parser().
				    setSigningKey(jwtSecret).
				    parseClaimsJws(token).
				    getBody().getSubject();
	}
	
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true; // ust satirda exception olusmazsa true donecek
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
		    logger.error("An error occured while validating jwt token", e.getMessage());
		}
		return false;
	}
}
