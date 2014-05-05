/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services.impl;

import com.elton.library.domain.Book;
import com.elton.library.repository.BookRepository;
import com.elton.library.services.GetAvailableBooksService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 101Lenboxs
 */
@Service
public class GetAvailableBooksServiceImpl implements GetAvailableBooksService{
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<Book> getAvailableBooks(){
        List<Book> books = new ArrayList<>();
        List<Book> allBooks = bookRepository.findAll();

        for (Book book : allBooks) {
            if(book.isAvailable()) {
                books.add(book);
            }
        }
        return books;
    }
}
