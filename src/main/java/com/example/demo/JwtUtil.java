package com.example.demo;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component // spring creates instance and makes it available for dependency injection in other classes
public class JwtUtil {
	
	private static final String SECRET = "kljabsdfdd0abdf0biusflakfjas90fansfaosbfsf70a89fabib09aba";
	private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour (milliseconds)
	
	private final static Key key = Keys.hmacShaKeyFor(SECRET.getBytes()); // converts SECRET to byte array and passes to hmac method
	
	public String generateToken(String username) {
		 return Jwts.builder()
			.setSubject(username)
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
	}
	
	public String extractUsername(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token, String username) {
		return username.equals(extractUsername(token)) && !isExpired(token);
	}
	

	boolean isExpired(String token) {
		Date exp = Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		return exp.before(new Date());
	}

}