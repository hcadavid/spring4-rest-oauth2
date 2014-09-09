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
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user=authentication.getPrincipal().toString();
        String pwd=authentication.getCredentials().toString();
        
        //PUT Auth Bean here
        
        boolean result=user.equals("myuser") && pwd.equals("mypassword");
                //= aaaProxy.isValidUser(authentication.getPrincipal()
                //.toString(), authentication.getCredentials().toString());
 
        if (result) {
            List<GrantedAuthority> grantedAuthorities
                    = new ArrayList<GrantedAuthority>();
            AAAUserAuthenticationToken auth
                    = new AAAUserAuthenticationToken(authentication.getPrincipal(),
                            authentication.getCredentials(), grantedAuthorities);

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
