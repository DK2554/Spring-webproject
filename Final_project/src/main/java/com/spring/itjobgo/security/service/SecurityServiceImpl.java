package com.spring.itjobgo.security.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityServiceImpl implements SecurityService{

	//토큰 생성시 필요한 시크릿값 (내가 몰라도 되는 값이긴 한대 그래도 외부 유출되면 안됨)
	private static final String SECRET_KEY = "iouytrdfcvghjkluytfgcvbnjkliuytfdcvbhj";
	
	@Override
	public String createToken(String login, long ttlMillis) {
		//토큰 발행
		 if (ttlMillis <= 0) {
	            throw new RuntimeException("Expiry time must be greater than Zero : ["+ttlMillis+"] ");
	        }
	        // 토큰을 서명하기 위해 사용해야할 알고리즘 선택 : HS256
	        SignatureAlgorithm  signatureAlgorithm= SignatureAlgorithm.HS256;
	 
	        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
	        
	        //jwt 빌더
	        JwtBuilder builder = Jwts.builder()
	                .setSubject(login)
	                .signWith(signatureAlgorithm, signingKey);
	        
	        long nowMillis = System.currentTimeMillis();
	        
	        builder.setExpiration(new Date(nowMillis + ttlMillis));
	        return builder.compact();
	}

	@Override
	public String getSubject(String token) {
		 Claims claims = Jwts.parser()
	                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
	                .parseClaimsJws(token).getBody();
	        return claims.getSubject();
	}
	
	

}
