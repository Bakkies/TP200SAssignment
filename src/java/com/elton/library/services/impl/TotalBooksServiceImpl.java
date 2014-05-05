/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services.impl;

import com.elton.library.domain.Book;
import com.elton.library.repository.BookRepository;
import com.elton.library.services.TotalBooksService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalBooksServiceImpl implements TotalBooksService{
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getTotalBooks(){
        return bookRepository.findAll();
    }
}
