/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 101Lenboxs
 */
@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name name;
    private String address;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    private int age;
    private String gender;

    private Member(Builder builder) {
        id = builder.id;
        name = builder.name;
        address = builder.address;
        startDate = builder.startDate;
        age = builder.age;
        gender = builder.gender;
    }

    public Member() {
    }
    
    public static class Builder{
        private Long id;
        private Name name;
        private String address;
        private Date startDate;
        private int age;
        private String gender;

        public Builder(Name name) {   
            this.name = name;
        }
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder startDate(Date startDate){
            this.startDate = startDate;
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
        
        public Builder member(Member member){
            id = member.getId();
            name = member.getName();
            address = member.getAddress();
            startDate = member.getStartDate();
            age = member.getAge();
            gender = member.getGender();
            return this;
        }
        
        public Member build(){
            return new Member(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.domain.Member[ id=" + id + " ]";
    }
    
}
