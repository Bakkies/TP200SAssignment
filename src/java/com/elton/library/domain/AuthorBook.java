/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 101Lenboxs
 */
@Entity
public class AuthorBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    public Long getId() {
        return id;
    }
    
    private AuthorBook(Builder builder) {
        id = builder.id;
        book = builder.book;
        author = builder.author;
    }

    public AuthorBook() {
    }
    
    public static class Builder{
        private Long id;
        private Book book;
        private Author author;

        public Builder(Book book) {   
            this.book = book;
        }
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder author(Author author){
            this.author = author;
            return this;
        }
        public Builder authorbook(AuthorBook authorbook){
            id = authorbook.getId();
            book = authorbook.getBook();
            author = authorbook.getAuthor();
            return this;
        }
        
        public AuthorBook build(){
            return new AuthorBook(this);
        }
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Book getBook() {
        return book;
    }

    public Author getAuthor() {
        return author;
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
        if (!(object instanceof AuthorBook)) {
            return false;
        }
        AuthorBook other = (AuthorBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.library.domain.AuthorBook[ id=" + id + " ]";
    }
}
