package com.spring.itjobgo.security;

public interface SecurityService {
	 String createToken(String subject, long ttlMillis);
	 String getSubject(String token);
}
