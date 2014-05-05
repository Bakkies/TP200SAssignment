/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.repository;

import com.elton.library.domain.AuthorBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long>{
    
}
