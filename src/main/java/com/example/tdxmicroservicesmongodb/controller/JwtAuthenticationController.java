package com.example.tdxmicroservicesmongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdxmicroservicesmongodb.model.JwtRequest;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Value("${spring.jwt.secret}")
	private String secretKey;
	
	private final String SECRET_JWT = "tdxjwtToken2022";
	
	
	@RequestMapping(value = "/api/v1/auth", method = RequestMethod.POST)
	public JwtRequest login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		JwtRequest user = new JwtRequest();
		user.setUsername(username);
		user.setToken(token);		
		return user;
		
	}
	
	
	private String getJWTToken(String username) {
		//String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER_TDX");
		
		String token = Jwts
				.builder()
				.setId("tdxBackEnd")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 300000))
				.signWith(SignatureAlgorithm.HS512,SECRET_JWT.getBytes())
				.compact();

		return token;
	}
}