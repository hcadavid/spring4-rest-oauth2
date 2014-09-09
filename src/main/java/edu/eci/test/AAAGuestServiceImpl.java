/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 *
 * @author hcadavid
 */
public class AAAGuestServiceImpl implements ClientDetailsService {

    
    private String id;
    private String secretKey;
    
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        
        if (clientId.equals(id))
        {
            List<String> authorizedGrantTypes = new ArrayList<String>();
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");
 
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId(id);
            clientDetails.setClientSecret(secretKey);
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
             
            return clientDetails;
        }
        else {
            throw new NoSuchClientException("No client recognized with id: "
                    + clientId);
        }
        
    }
    
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getSecretKey() {
        return secretKey;
    }
 
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    
    
}
