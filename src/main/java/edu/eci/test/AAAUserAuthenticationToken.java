package edu.eci.test;


import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class AAAUserAuthenticationToken extends AbstractAuthenticationToken {
 
    private static final long serialVersionUID = -1092219614309982278L;
    private final Object principal;
    private Object credentials;
 
    public AAAUserAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }
 
    public Object getCredentials() {
        return this.credentials;
    }
 
    public Object getPrincipal() {
        return this.principal;
    }
}