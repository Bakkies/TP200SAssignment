/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 101Lenboxs
 */
@Entity
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name name;
    private int age;
    private String gender;

    private Author(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        gender = builder.gender;
        }

    public Author() {
    }
    
    public static class Builder{
        private Long id;
        private Name name;
        private int age;
        private String gender;

        public Builder(Name name) {   
            this.name = name;
        }
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder age(int age){
            this.age = age;
            return this;
        }
        
        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }
        
        public Builder author(Author author){
            id = author.getId();
            name = author.getName();
            age = author.getAge();
            gender = author.getGender();
            return this;
        }
        
        public Author build(){
            return new Author(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.domain.Author[ id=" + id + " ]";
    }
    
}
