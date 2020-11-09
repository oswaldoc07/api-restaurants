package com.ecomers.api.restaurants.web.security.filter;


import com.ecomers.api.restaurants.domain.service.UserDetailService;
import com.ecomers.api.restaurants.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class JwtFilterRequest  extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailService userDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
       // authorizationHeader = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvc3dhbGRvIiwiaWF0IjoxNjAzMDgwNDc1LCJleHAiOjE2MDMxMTY0NzV9.27Yg3y1BQH7wiHx2vKyL2gK45mXiVi09yzDCbZ5q_NQ";
        HttpServletResponse response = (HttpServletResponse) res;
        String url= request.getRequestURL().toString();

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Lang,append,delete,entries,foreach,get,has,keys,set,values,Authorization");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        /*response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Credentials,Authorization,Access-Control-Allow-Origin,Access-Control-Allow-Headers, Origin,Accept," +
                " X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");*/
     //   response.addHeader("Access-Control-Expose-Headers", "Content-Length,Content-Language,Content-Type,Authorization");
/*
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
       // response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,observe");
       // response.setHeader("Access-Control-Max-Age", "3600");
       response.setHeader("Access-Control-Allow-Credentials", "true");
       /*
        response.addHeader("Access-Control-Expose-Headers", "responseType");
        response.addHeader("Access-Control-Expose-Headers", "observe");

        response.addHeader("Access-Control-Expose-Headers", "");
        response.addHeader("Access-Control-Expose-Headers", "");*/
        String authorizationHeader = request.getHeader("Authorization");

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


   /* @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
        registrationBean.setName("CORS FIlter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }*/
}
