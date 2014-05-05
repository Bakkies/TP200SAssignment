/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 101Lenboxs
 */
@Entity
public class Borrowed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dueDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private Borrowed(Builder builder) {
        id = builder.id;
        date = builder.date;
        dueDate = builder.dueDate;
        book = builder.book;
        member = builder.member;
    }

    public Borrowed() {
    }
    
    public static class Builder{
        private Long id;
        private Date date;
        private Date dueDate;
        private Book book;
        private Member member;

        public Builder(Book book) {   
            this.book = book;
        }
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder date(Date date){
            this.date = date;
            return this;
        }
        public Builder dueDate(Date dueDate){
            this.dueDate = dueDate;
            return this;
        }
        public Builder member(Member member){
            this.member = member;
            return this;
        }
        public Builder borrowed(Borrowed borrowed){
            id = borrowed.getId();
            date = borrowed.getDate();
            dueDate = borrowed.getDueDate();
            book = borrowed.getBook();
            member = borrowed.getMember();
            return this;
        }
        
        public Borrowed build(){
            return new Borrowed(this);
        }
    }    
    
    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getDate() {
        return date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
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
        if (!(object instanceof Borrowed)) {
            return false;
        }
        Borrowed other = (Borrowed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.domain.Borrowd[ id=" + id + " ]";
    }
    
}