package com.ecomers.api.restaurants.web.security.filter;


import com.ecomers.api.restaurants.domain.service.UserDetailService;
import com.ecomers.api.restaurants.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest  extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailService userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
       // authorizationHeader = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvc3dhbGRvIiwiaWF0IjoxNjAzMDgwNDc1LCJleHAiOjE2MDMxMTY0NzV9.27Yg3y1BQH7wiHx2vKyL2gK45mXiVi09yzDCbZ5q_NQ";
        HttpServletResponse response = (HttpServletResponse) res;
        System.out.println("WebConfig; "+request.getRequestURI());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
        response.setHeader("Access-Control-Max-Age", "3600");
       response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Expose-Headers", "responseType");
        response.addHeader("Access-Control-Expose-Headers", "observe");


        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
         String jwt = authorizationHeader.substring(7);
         String username = jwtUtil.extractUsername(jwt);

         if(username !=null  && SecurityContextHolder.getContext().getAuthentication()==null){
             UserDetails userDetails = userDetailService.loadUserByUsername(username);
             if(jwtUtil.validateToken(jwt, userDetails)){
                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(authToken);
             }
         }
        }
        filterChain.doFilter(request,response);
    }
}
