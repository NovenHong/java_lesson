package com.jwt.test;

import org.junit.Test;

import com.owner.test.utils.JwtToken;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtTest {
	
	@Test
	public void test01() {
		
		String id = "1";
		
		String token = JwtToken.generate(id);
		
		
		System.out.println(token);
	}
	
	@Test
	public void test02() {
		String token = 
				"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoidGVzdCIsImlzcyI6InRlc3QiLCJpYXQiOjE1NzAxNzcwNjcsImV4cCI6MTU3MDI2MzQ2N30.Ku8O-0lvEbJ603pSScqLBr5cW7yFA2pULFXtS2J4RM0" + 1;
		
		try {
			
			JwtToken.validate(token);
			
		} catch (ExpiredJwtException  e) {
			System.out.println(e.getMessage());
		} catch (SignatureException  e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
