/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.domain;

/**
 * Represents a Role
 * 
 * @author Carlos Juarez
 */
public class Call {

    /**
     * The caller name
     */
    private String caller;
    
    /**
     * The phone Number
     */
    private String phoneNumber;

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Call{" + "name=" + caller + ", phoneNumber=" + phoneNumber + '}';
    }
    
}
