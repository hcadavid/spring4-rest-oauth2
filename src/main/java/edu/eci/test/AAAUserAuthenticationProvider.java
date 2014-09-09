/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author hcadavid
 */
public class AAAUserAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String user=a.getPrincipal().toString();
        String pwd=a.getCredentials().toString();
        
        if (user.equals("scott") && pwd.equals("tiger")) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            AAAUserAuthenticationToken auth =
  
            new AAAUserAuthenticationToken(user,
            pwd, grantedAuthorities);
 
            return auth;
        } else {
            throw new BadCredentialsException("Bad User Credentials.");
        }
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
    
    
}
