/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.services;

import caja.domain.Call;
import java.util.Date;
import java.util.List;

/**
 * Contains all the service methods of <code>Role</code>s
 * 
 * @author Carlos Juarez
 */
public interface CallService {


    
    /**
     * Saves a role
     * 
     * @param role - the role to save
     */
    public void saveRole(Call role);
    
    /**
     * Updates a role
     * 
     * @param role - the role to update
     */
    public void updateRole(Call role);

    /**
     * Gets all the roles
     * 
     * @return roles found
     */
    public List<Call> getAllRoles();

    /**
     * Removes a role
     * 
     * @param name - the name of role that is going to be removed
     */
    public void removeRole(String name);

    /**
     * Finds a role
     * 
     * @param name - name of the role that is going to be found
     * @return role found
     */
    public Call findRole(String name);
    
    /**
     * @return the default role
     */
    public Call getDefaultRole();
    
}
