package com.app.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
		
		@Autowired
		private UserDetailsServiceImpl userDetailsService;
		@Autowired
		private JwtUtils jwtUtils;//class having all methods which validate token,check token expire or not
		
		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//retrive token from header
		final String requestTokenHeader=request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		
		String username=null;
		String jwtToken=null;
		
		if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer"))
		{
			jwtToken=requestTokenHeader.substring(7);//token start from index 7
			
			try {
				username=this.jwtUtils.extractUsername(jwtToken);//with the help of token retrive username
			}catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token has expired ");
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error");
			}
			
		}
		else {
			System.out.println("Invalid token not start with bearer string");
		}
		
		//validate token
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			//retrive userdetails from db
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
			if(this.jwtUtils.validateToken(jwtToken, userDetails))
			{
				//token is valid
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()); 
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
	}
	
	
}
