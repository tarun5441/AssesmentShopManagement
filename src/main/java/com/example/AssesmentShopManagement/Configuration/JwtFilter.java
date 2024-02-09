package com.example.AssesmentShopManagement.Configuration;

import com.example.AssesmentShopManagement.Services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

// @Configuration means among the other beans this is prioritized
@Configuration
public class JwtFilter extends GenericFilterBean {

    private TokenService tokenservice;

    public JwtFilter(TokenService tokenservice) {
        this.tokenservice=tokenservice;
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterchain) throws IOException, ServletException {

        HttpServletRequest httpservletrequest=(HttpServletRequest) req;
        HttpServletResponse httpservletresponse=(HttpServletResponse) res;

        String token=httpservletrequest.getHeader("Authorization");
        if("OPTIONS".equalsIgnoreCase(httpservletrequest.getMethod())){
            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        if(allowRequestWithoutToken(httpservletrequest)){
            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
            filterchain.doFilter(req,res);

        }
        else{
            Integer id = Integer.valueOf(tokenservice.getUserIdToken(token));
            httpservletrequest.setAttribute("userId",id);
            filterchain.doFilter(req,res);
        }


    }

    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest){
        String[] matches=new String[]
                {"/login","/registration","/products","/categories"};
        for(String s:matches) {
            if (httpServletRequest.getRequestURI().contains(s))
                return true;
        }
        return false;
    }
}