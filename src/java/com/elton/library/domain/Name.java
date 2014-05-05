/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable 
public class Name implements Serializable {
    private String lastName;
    private String firstName;
    
    public Name(){
    
    }
    
    public Name(String lastName, String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
