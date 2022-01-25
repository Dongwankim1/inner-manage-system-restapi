package com.ims.com.jwt;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ims.usr.service.MemberService;
import com.ims.usr.vo.MemberVo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	private String secretKey = "webfirewood";
	
	//token persists for 1800second
	private long tokenValidTime = 30*60*1000L;
	
	@Autowired
	private MemberService memberService;
	
	//create jwt token
	public String createToken(String userPk,String roles) {
		
		Claims claims = Jwts.claims().setSubject(userPk);
		claims.put("roles", roles);
		Date now = new Date();
		
		return Jwts.builder().setClaims(claims)
				.setIssuedAt(now).setExpiration(new Date(now.getTime()+tokenValidTime))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
		
	}
	
	//jwt select auth info
	public Authentication getAuthentication(String token) {

		return null;
	}
	
	// 토큰 회원 정보 추출
	public String getUserPk(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	//Request의 Header에서 token 값을 가져온다 "X-AUTH_TOKEN" : "TOKEN 값"
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader("X-AUTH-TOKEN");
	}
	
	//토큰의 유효성 + 만료일자 확인
	public boolean validateToken(String jwtToken) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
			return !claims.getBody().getExpiration().before(new Date());
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	
}
