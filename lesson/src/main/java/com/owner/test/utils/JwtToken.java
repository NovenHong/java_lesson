package com.owner.test.utils;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {

	private static String key = "WkskpDhSkuBUOP*ITB*123456";
	private static SecretKey secret;
	
	static {
		secret = new SecretKeySpec(DatatypeConverter.parseBase64Binary(key),SignatureAlgorithm.HS256.getJcaName());
	}
	
	public static String generate(String id) {
		
		String token = Jwts.builder()
				.setId(id)
				.setSubject("test")
				.setIssuer("test")
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, secret)
				.setExpiration(new Date(System.currentTimeMillis()+86400000))
				.compact();
		
		return token;
	}
	
	public static Claims validate(String token) throws Exception {
		Claims claims = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
		
		return claims;
	}
}
