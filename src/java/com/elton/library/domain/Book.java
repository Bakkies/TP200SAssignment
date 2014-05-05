/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 101Lenboxs
 */
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long isbn;
    private String title;
    private boolean available;
    
    private Book(Builder builder) {
        id = builder.id;
        isbn = builder.isbn;
        title = builder.title;
        available = builder.available;
    }

    public Book() {
    
    }
    public static class Builder{
        private Long id;
        private Long isbn;
        private String title;
        private boolean available;

        public Builder(String title) {
            this.title = title;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder isbn(Long isbn){
            this.isbn = isbn;
            return this;
        }
        
        public Builder isbn(boolean available){
            this.available = available;
            return this;
        }
        
        public Builder available(boolean available){
            this.available = available;
            return this;
        }
        
        public Builder book(Book book){
            id = book.getId();
            isbn = book.getIsbn();
            title = book.getTitle();
            available = book.isAvailable();
            return this;
        }

        public Book build(){
            return new Book(this);
        }  
    }
    public Long getId() {
        return id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.domain.Book[ id=" + id + " ]";
    }
    
}
